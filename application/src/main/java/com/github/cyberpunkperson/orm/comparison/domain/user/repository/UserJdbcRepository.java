package com.github.cyberpunkperson.orm.comparison.domain.user.repository;

import com.github.cyberpunkperson.orm.comparison.domain.user.User;
import com.github.cyberpunkperson.orm.comparison.domain.value.Address;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
interface UserJdbcRepository extends CrudRepository<User, UUID> {


    @Override
    @Transactional
    default User save(User user) {
        saveAddress(user.getAddress());
        save(user.getId(), user.getName(), user.getAddress().getId());
        return user;
    }

    @Query("""
            insert into users as users (id, name, address_id) 
            values (:id, :name, :addressId) 
            on conflict (id) 
            do update 
               set name = excluded.name 
            returning id, name, address_id;
            """)
    User save(UUID id, String name, UUID addressId);

    @Override
    @Query("""
            select 
                users.*, 
                address.id as address_id, 
                address.zip as address_zip, 
                address.city as address_city, 
                address.street as address_street, 
                address.country as address_country 
            from users users 
                left outer join address address on address.id = users.address_id 
            where users.id = :userId;
            """)
    Optional<User> findById(UUID userId);

    @Override
    @Query("""
            select 
                users.*, 
                address.id as address_id, 
                address.zip as address_zip, 
                address.city as address_city, 
                address.street as address_street, 
                address.country as address_country 
            from users users 
                left outer join address address on address.id = users.address_id;
            """)
    List<User> findAll();

    default Address saveAddress(Address address) {
        return this.saveAddress(address.getId(), address.getCountry(), address.getCity(), address.getStreet(), address.getZip());
    }

    @Query("""
            insert into address 
            values (:id, :country, :city, :street, :zip) 
            on conflict (id) 
            do update 
               set country = excluded.country, city = excluded.city, street = excluded.street, zip = excluded.zip 
            returning id, country, city, street, zip;
            """)
    Address saveAddress(UUID id, String country, String city, String street, Integer zip);

}
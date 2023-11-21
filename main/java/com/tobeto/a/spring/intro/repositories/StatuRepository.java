package com.tobeto.a.spring.intro.repositories;

import com.tobeto.a.spring.intro.entities.Statu;
import org.springframework.data.jpa.repository.JpaRepository;

//Generic
//Generic Typlar Referance Type olarak belirtilmelidir.
public interface StatuRepository extends JpaRepository<Statu, Integer>
{
}

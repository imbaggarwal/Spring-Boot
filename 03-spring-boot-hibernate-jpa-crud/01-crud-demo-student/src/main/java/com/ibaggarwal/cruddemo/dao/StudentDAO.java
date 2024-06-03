package com.ibaggarwal.cruddemo.dao;

import com.ibaggarwal.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);
}

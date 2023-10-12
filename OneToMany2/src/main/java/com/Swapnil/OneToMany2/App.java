// Q.1)Create Student and Course Entity to show one to Many and Many to one mapping.

package com.Swapnil.OneToMany2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Swapnil.entity.*;

public class App {
    public static void main(String[] args) {
        // Obtain a Hibernate SessionFactory
        SessionFactory sessionFactory = HibernateUtil1.getSessionFactory();

        // Open a new Hibernate session
        Session session = sessionFactory.openSession();

        try {
            // Create the first course "Java Full Stack"
            Course course = new Course();
            course.setCoursename("Java Full Stack");

            // Create two students for the "Java Full Stack" course
            Student student1 = new Student();
            student1.setStudname("Amit");
            student1.setCourse(course);

            Student student2 = new Student();
            student2.setStudname("Arun");
            student2.setCourse(course);

            // Add the students to the "Java Full Stack" course
            course.getStudent().add(student1);
            course.getStudent().add(student2);

            // Create the second course "Python Full Stack"
            Course course2 = new Course();
            course2.setCoursename("Python Full Stack");

            // Create two students for the "Python Full Stack" course
            Student student3 = new Student();
            student3.setStudname("Swapnil");
            student3.setCourse(course2);

            Student student4 = new Student();
            student4.setStudname("Savita");
            student4.setCourse(course2);

            // Add the students to the "Python Full Stack" course
            course2.getStudent().add(student3);
            course2.getStudent().add(student4);

            // Begin a transaction, save the courses and students to the database, and commit the transaction
            session.beginTransaction();
            session.save(course);
            session.save(course2);
            session.getTransaction().commit();
        } finally {
            // Close the session and the SessionFactory
            session.close();
            sessionFactory.close();
        }
    }
}

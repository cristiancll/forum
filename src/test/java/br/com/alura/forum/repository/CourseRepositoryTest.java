package br.com.alura.forum.repository;

import br.com.alura.forum.model.Course;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class CourseRepositoryTest {

    @Autowired private CourseRepository repository;
    @Autowired private TestEntityManager em;
    
    
    @Test
    public void shouldFindByName() {
        String courseName = "HTML 5";
        
        Course newCourse = new Course();
        newCourse.setName(courseName);
        newCourse.setCategory("Programação");
        em.persist(newCourse);
        
        Course course = repository.findByName(courseName);
        Assert.assertNotNull(course);
        Assert.assertEquals(courseName, course.getName());
    }
    @Test
    public void shouldNotFindByName() {
        String courseName = "HTML 6";
        Course course = repository.findByName(courseName);
        Assert.assertNull(course);
    }
}
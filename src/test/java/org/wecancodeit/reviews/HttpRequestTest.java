package org.wecancodeit.reviews;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.wecancodeit.reviews.Models.Category;
import org.wecancodeit.reviews.storage.CategoryStorage;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)


 public class HttpRequestTest {

       @LocalServerPort
        private int port;
        @Autowired
        private TestRestTemplate testRestTemplate;
        @Autowired
        private CategoryStorage categoryStorage;
        private Category testCategory;
        @BeforeEach
        public void testClassSetup() {
            testCategory = new Category("Red","Fantastic");
            categoryStorage.store(testCategory);
        }
        @Test
        public void categoriesEndPointReturnsOK() {
            ResponseEntity<String> response = testRestTemplate.getForEntity(
                    "http://localhost:" + port + "/categories", String.class);
            assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        }
        @Test
        public void specificEndPointReturnsOK() {
            ResponseEntity<String> response = testRestTemplate.getForEntity(
                    "http://localhost:" + port + "/categories/" + testCategory.getId(), String.class);
            assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        }
    }


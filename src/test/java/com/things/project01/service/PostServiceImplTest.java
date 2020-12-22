package com.things.project01.service;

import com.things.project01.repository.PostRepository;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.transaction.Transactional;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@Transactional
class PostServiceImplTest {

    @LocalServerPort
    int port;

    @BeforeEach
    void setup() {
        RestAssured.port = port;
    }

    @Autowired
    private PostRepository postRepository;

    @Test
    @DisplayName("게시글 등록")
    void created() {
        // given
        String requestParams =
                "{\n" +
                        "\"title\": \"title\",\n" +
                        "\"content\": \"content\",\n" +
                        "\"author\": \"author\",\n" +
                        "\"password\": \"1234\"\n" +
                        "}";

        // when / then
        RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .body(requestParams)
                .when().post("/api/created")
                .then().log().all()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    @DisplayName("게시글 단일 조회")
    void findById() {
        created();
        Long id = 1L;

        // when / then
        RestAssured.given().log().all()
                .when().get("/" + id.intValue())
                .then().log().all()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    void findAll() {
    }

    @Test
    void checkPw() {
        created();
        String requestParams =
                "{\n" +
                        "\"id\": \"1\",\n" +
                        "\"password\": \"1234\"\n" +
                        "}";

        RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .body(requestParams)
                .when().get("/api/check")
                .then().log().all()
                .statusCode(HttpStatus.OK.value());
    }
}
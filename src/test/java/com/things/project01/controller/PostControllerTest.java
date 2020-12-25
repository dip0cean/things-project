package com.things.project01.controller;

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
class PostControllerTest {

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
    void 게시글등록() {
        // given
        // when / then
        for (int i = 0; i < 1000; i++) {
            String requestParams =
                    "{\n" +
                            "\"title\": \"테스트_" + (i + 1) + "\",\n" +
                            "\"content\": \"테스트\",\n" +
                            "\"author\": \"테스트\",\n" +
                            "\"password\": \"1234\"\n" +
                            "}";

            RestAssured.given().log().all()
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .accept(MediaType.APPLICATION_JSON_VALUE)
                    .body(requestParams)
                    .when().post("/api/created")
                    .then().log().all()
                    .statusCode(HttpStatus.OK.value());
        }
    }

    @Test
    @DisplayName("게시글 단일 조회")
    void 게시글찾기() {
        게시글등록();
        Long id = 1L;

        // when / then
        RestAssured.given().log().all()
                .when().get("/post/" + id.intValue())
                .then().log().all()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    void findAll() {
    }

    @Test
    @DisplayName("비밀번호 확인")
    void 비밀번호확인() {
        게시글등록();
        String requestParams =
                "{\n" +
                        "\"id\": \"1\",\n" +
                        "\"password\": \"1234\"\n" +
                        "}";

        RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .body(requestParams)
                .when().post("/api/check")
                .then().log().all()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    @DisplayName("게시글 수정")
    void 게시글수정() {
        비밀번호확인();
        // given
        String requestParams =
                "{\n" +
                        "\"id\": \"1\",\n" +
                        "\"title\": \"테스트제목\",\n" +
                        "\"content\": \"테스트내용\",\n" +
                        "\"author\": \"테스트유저\",\n" +
                        "\"password\": \"4321\"\n" +
                        "}";
        RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .body(requestParams)
                .when().patch("/api/update")
                .then().log().all()
                .statusCode(HttpStatus.OK.value());
    }
}
package com.uv.ws;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.uv.ws.client.RncClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class SpringWsApplicationTests {

  @Autowired
  private RncClient rncClient;

  @Test
  public void testUploadDocOp() {
    assertThat(rncClient.UploadDocOp("Claudio", "Araya", "Valenzuela", "15095162-3")).
            isEqualTo("Nombre: Claudio Araya Valenzuela RUT: 15095162-3");
  }
}

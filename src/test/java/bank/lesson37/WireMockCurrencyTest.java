package bank.lesson37;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class WireMockCurrencyTest {
    @Autowired
    protected WireMockServer wireMockServer;
    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected ObjectMapper objectMapper;

    @Test
    void checkCurrencyConverted() throws Exception {
        wireMockServer.stubFor(
                WireMock.get(urlPathEqualTo("/currency"))
                        .withQueryParam("apikey", equalTo("kate"))
                        .withQueryParam("base_currency", equalTo("UAH"))
                        .withQueryParam("currencies", equalTo("USD"))
                        .willReturn(aResponse()
                                .withHeader("Content-Type", "application/json")
                                .withBody("""
                                        {
                                             "data": {
                                                 "USD": {
                                                     "code": "USD",
                                                     "value": 0.055
                                                 }
                                             }
                                         }
                                        """))
        );

        var query = MockMvcRequestBuilders.get("/currency")
                .param("fromCurrency", "UAH")
                .param("toCurrency", "USD")
                .param("amount", "100");

        var response = mockMvc.perform(query)
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertThat(response).isEqualTo("5.5");
    }
}

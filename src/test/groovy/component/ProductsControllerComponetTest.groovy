package component

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpHeaders
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import spock.lang.Specification
import com.sapient.poc.DemoApplication

import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest(classes = DemoApplication, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ProductsControllerComponetTest extends Specification{

    @Autowired
    private MockMvc mockMvc
    String requestBody = "{\n" +
            "\"name\": \"Very New Shirt Blue\",\n" +
            "\"description\": \"BLUE SHIRT WIT STIPE\",\n" +
            "\"price\": 12233.99,\n" +
            "\"seller_id\": 13,\n" +
            "\"category_id\":4,\n" +
            "\"color_id\": 11,\n" +
            "\"brand_id\": 7\n" +
            "}";

    def "get product list happy path - GET"(){
        def request = get("/products/products")

        when:
        ResultActions result = mockMvc.perform(request)

        then:
        result.andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))

    }


    def "update product happy path - PUT"(){
        def request = put("/products/product/17").headers(getRequestHeaders()).content(requestBody)

        when:
        ResultActions result = mockMvc.perform(request)

        then:
        result.andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))

    }


    def "update product unhappy path - PUT"(){
        def request = put("/products/product/24").headers(getRequestHeaders()).content(requestBody)

        when:
        ResultActions result = mockMvc.perform(request)

        then:
        result.andExpect(status().isNotFound())


    }


    private static HttpHeaders getRequestHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders()
        httpHeaders.setContentType(APPLICATION_JSON)
        return httpHeaders
    }

}

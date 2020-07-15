package br.com.marco.cadeacerva.sales.contracts;

import br.com.marco.cadeacerva.sales.domain.Sale;
import br.com.marco.cadeacerva.sales.domain.SaleRepository;
import br.com.marco.cadeacerva.sales.domain.SaleSearchCriteriaWrapper;
import br.com.marco.cadeacerva.testcommons.utils.annotation.ContractTest;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContractTest
@SpringBootTest
@WithMockUser
public class ContractsBaseClass {

    @Autowired
    WebApplicationContext context;

    @MockBean
    SaleRepository saleRepository;

    @Before
    public void setUp() {
        RestAssuredMockMvc.webAppContextSetup(this.context);
        when(saleRepository.findBy(any(SaleSearchCriteriaWrapper.class), any(Pageable.class)))
                .thenReturn(new PageImpl<>(
                        Arrays.asList(
                                new Sale("address", Arrays.asList("tag1", "tag2"), 10.0, new double[]{10.0, 20.0})
                        ), PageRequest.of(0, 1), 2));
    }
}

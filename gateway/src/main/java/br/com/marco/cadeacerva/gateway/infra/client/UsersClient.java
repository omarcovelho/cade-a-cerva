package br.com.marco.cadeacerva.gateway.infra.client;

import br.com.marco.cadeacerva.gateway.infra.client.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("users")
public interface UsersClient {

    @PostMapping("/user/{email}")
    UserDTO saveUser(@PathVariable("email") String email, UserDTO user);
}

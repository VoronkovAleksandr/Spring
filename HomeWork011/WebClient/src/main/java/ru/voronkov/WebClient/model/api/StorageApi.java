package ru.voronkov.WebClient.model.api;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("api.storage")
public class StorageApi {

    private String basicUri;
}

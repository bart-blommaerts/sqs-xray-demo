package be.bbconsulting.sqsxray.demo.config;

import com.jashmore.sqs.spring.client.DefaultSqsAsyncClientProvider;
import com.jashmore.sqs.spring.client.SqsAsyncClientProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

@Configuration
@Profile("local")
public class SqsConfigLocal {

    @Value("aws_region")
    private String region;

    @Bean
    public SqsAsyncClientProvider sqsAsyncClientProvider() {
        return new DefaultSqsAsyncClientProvider(SqsAsyncClient.builder().credentialsProvider(new LocalCredentialsProvider()).region(Region.of(region)).build());
    }

    public class LocalCredentialsProvider implements AwsCredentialsProvider {

        @Value("aws_access_key_id")
        private String accessKey;

        @Value("aws_secret_access_key")
        private String secretAccressKey;

        @Value("aws_session_token")
        private String sessionToken;


        @Override
        public AwsCredentials resolveCredentials() {
            return AwsSessionCredentials.create(accessKey, secretAccressKey, sessionToken);
        }
    }
}

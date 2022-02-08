package se.skltp.aggregatingservices.riv.clinicalprocess.healthcond.description.getcaredocumentation;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import riv.clinicalprocess.healthcond.description.getcaredocumentationresponder.v3.GetCareDocumentationResponseType;
import se.skltp.aggregatingservices.tests.CreateAggregatedResponseTest;


@ExtendWith(SpringExtension.class)
public class GACDCreateAggregatedResponseTest extends CreateAggregatedResponseTest {

  public GACDCreateAggregatedResponseTest() {
      super(new ServiceTestDataGenerator(), new GACDAgpServiceFactoryImpl(), new GACDAgpServiceConfiguration());
  }

  @Override
  public int getResponseSize(Object response) {
        GetCareDocumentationResponseType responseType = (GetCareDocumentationResponseType)response;
    return responseType.getCareDocumentation().size();
  }
}
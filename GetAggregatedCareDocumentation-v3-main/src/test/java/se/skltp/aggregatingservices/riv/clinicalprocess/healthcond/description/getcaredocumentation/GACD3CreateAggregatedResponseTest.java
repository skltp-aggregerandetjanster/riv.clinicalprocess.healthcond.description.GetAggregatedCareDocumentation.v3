package se.skltp.aggregatingservices.riv.clinicalprocess.healthcond.description.getcaredocumentation;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import riv.clinicalprocess.healthcond.description.getcaredocumentationresponder.v3.GetCareDocumentationResponseType;
import se.skltp.aggregatingservices.tests.CreateAggregatedResponseTest;


@ExtendWith(SpringExtension.class)
public class GACD3CreateAggregatedResponseTest extends CreateAggregatedResponseTest {

  public GACD3CreateAggregatedResponseTest() {
      super(new ServiceTestDataGenerator(), new GACD3AgpServiceFactoryImpl(), new GACD3AgpServiceConfiguration());
  }

  @Override
  public int getResponseSize(Object response) {
        GetCareDocumentationResponseType responseType = (GetCareDocumentationResponseType)response;
    return responseType.getCareDocumentation().size();
  }
}
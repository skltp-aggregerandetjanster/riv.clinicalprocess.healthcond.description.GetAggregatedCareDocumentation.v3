package se.skltp.aggregatingservices.riv.clinicalprocess.healthcond.description.getcaredocumentation;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import se.skltp.aggregatingservices.tests.CreateRequestListTest;

@ExtendWith(SpringExtension.class)
public class GACD3CreateRequestListTest extends CreateRequestListTest {

  public GACD3CreateRequestListTest() {
    super(new ServiceTestDataGenerator(), new GACD3AgpServiceFactoryImpl(), new GACD3AgpServiceConfiguration());
  }
}
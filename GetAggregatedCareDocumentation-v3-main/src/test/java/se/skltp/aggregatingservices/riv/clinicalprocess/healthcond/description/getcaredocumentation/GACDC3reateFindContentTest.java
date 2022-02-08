package se.skltp.aggregatingservices.riv.clinicalprocess.healthcond.description.getcaredocumentation;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import se.skltp.aggregatingservices.tests.CreateFindContentTest;


@ExtendWith(SpringExtension.class)
public class GACDC3reateFindContentTest extends CreateFindContentTest {

  public GACDC3reateFindContentTest() {
    super(new ServiceTestDataGenerator(), new GACD3AgpServiceFactoryImpl(), new GACD3AgpServiceConfiguration());
  }

}

package se.skltp.aggregatingservices.riv.clinicalprocess.healthcond.description.getcaredocumentation;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import se.skltp.aggregatingservices.tests.CreateFindContentTest;


@ExtendWith(SpringExtension.class)
public class GACDCreateFindContentTest extends CreateFindContentTest {

  public GACDCreateFindContentTest() {
    super(new ServiceTestDataGenerator(), new GACDAgpServiceFactoryImpl(), new GACDAgpServiceConfiguration());
  }

}


package se.skltp.aggregatingservices.riv.clinicalprocess.healthcond.description.getcaredocumentation;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import riv.clinicalprocess.healthcond.description.getcaredocumentation.v3.rivtabp21.GetCareDocumentationResponderInterface;
import riv.clinicalprocess.healthcond.description.getcaredocumentation.v3.rivtabp21.GetCareDocumentationResponderService;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "getaggregatedcaredocumentation.v3")
public class GACD3AgpServiceConfiguration extends se.skltp.aggregatingservices.configuration.AgpServiceConfiguration {

public static final String SCHEMA_PATH = "/schemas/Domain_3.0_RC12/interactions/GetCareDocumentationInteraction/GetCareDocumentationInteraction_3.0_RIVTABP21.wsdl";

  public GACD3AgpServiceConfiguration() {

    setServiceName("GetAggregatedCareDocumentation-v3");
    setTargetNamespace("urn:riv:clinicalprocess:healthcond:description:GetCareDocumentation:3:rivtabp21");

    // Set inbound defaults
    setInboundServiceURL("http://localhost:9028/GetAggregatedCareDocumentation/service/v3");
    setInboundServiceWsdl(SCHEMA_PATH);
    setInboundServiceClass(GetCareDocumentationResponderInterface.class.getName());
    setInboundPortName(GetCareDocumentationResponderService.GetCareDocumentationResponderPort.toString());

    // Set outbound defaults
    setOutboundServiceWsdl(SCHEMA_PATH);
    setOutboundServiceClass(getInboundServiceClass());
    setOutboundPortName(getInboundPortName());

    // FindContent
    setEiServiceDomain("riv:clinicalprocess:healthcond:description");
    setEiCategorization("voo");

    // TAK
    setTakContract("urn:riv:clinicalprocess:healthcond:description:GetCareDocumentationResponder:3");

    // Set service factory
    setServiceFactoryClass(GACD3AgpServiceFactoryImpl.class.getName());
    }


}

package se.skltp.aggregatingservices.riv.clinicalprocess.healthcond.description.getcaredocumentation;

import lombok.extern.log4j.Log4j2;
import org.apache.cxf.message.MessageContentsList;
import org.springframework.stereotype.Service;
import riv.clinicalprocess.healthcond.description.getcaredocumentationresponder.v3.GetCareDocumentationResponseType;
import riv.clinicalprocess.healthcond.description.getcaredocumentationresponder.v3.GetCareDocumentationType;
import riv.clinicalprocess.healthcond.description.v3.*;
import se.skltp.aggregatingservices.data.TestDataGenerator;

import java.util.concurrent.ThreadLocalRandom;

@Log4j2
@Service
public class ServiceTestDataGenerator extends TestDataGenerator {

	@Override
	public String getPatientId(MessageContentsList messageContentsList) {
		GetCareDocumentationType request = (GetCareDocumentationType) messageContentsList.get(1);
		String patientId = request.getPatientId().getExtension();
		return patientId;
	}

	@Override
	public Object createResponse(Object... responseItems) {
		log.info("Creating a response with {} items", responseItems.length);
		GetCareDocumentationResponseType response = new GetCareDocumentationResponseType();
		for (int i = 0; i < responseItems.length; i++) {
			response.getCareDocumentation().add((CareDocumentationType)responseItems[i]);
		}

		log.info("response.toString:" + response.toString());

		return response;
	}

	@Override
	public Object createResponseItem(String logicalAddress, String registeredResidentId, String businessObjectId, String time) {
		log.debug("Created ResponseItem for logical-address {}, registeredResidentId {} and businessObjectId {}",
				new Object[]{logicalAddress, registeredResidentId, businessObjectId});

		HeaderType header = new HeaderType();

		AccessControlHeaderType accessControlHeader = new AccessControlHeaderType();
		IIType accountableHealthcareProvider = new IIType();
		accessControlHeader.setAccountableHealthcareProvider(accountableHealthcareProvider);
		header.setAccessControlHeader(accessControlHeader);

		IIType sourceSystem = new IIType();
		sourceSystem.setRoot("1.2.752.129.2.1.4.1");
		sourceSystem.setExtension(logicalAddress + "-"  + ThreadLocalRandom.current().nextInt(20));
		header.setSourceSystemId(sourceSystem);

		RecordType record = new RecordType();
		IIType recordId = new IIType();
		recordId.setRoot(businessObjectId);
		record.setId(recordId);
		record.setTimestamp(time);
		header.setRecord(record);

		CareDocumentationBodyType body = new CareDocumentationBodyType();
		body.setClinicalDocumentNoteTitle("title");
		body.setClinicalDocumentNoteText("text");

		CareDocumentationType response = new CareDocumentationType();
		response.setHeader(header);
		response.setBody(body);

		return response;
	}

	public Object createRequest(String patientId, String sourceSystemHSAId){
		GetCareDocumentationType requestType = new GetCareDocumentationType();

		IIType patient = new IIType();
		patient.setRoot("1.2.752.129.2.1.3.1");
		patient.setExtension(patientId);
		requestType.setPatientId(patient);

		IIType system = new IIType();
		system.setRoot("1.2.752.129.2.1.4.1");
		system.setExtension(sourceSystemHSAId);
		requestType.setSourceSystemId(system);

		return requestType;
	}
}

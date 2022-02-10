package se.skltp.aggregatingservices.riv.clinicalprocess.healthcond.description.getcaredocumentation;

import java.util.List;
import lombok.extern.log4j.Log4j2;
import riv.clinicalprocess.healthcond.description.enums.v3.ResultCodeEnum;
import riv.clinicalprocess.healthcond.description.getcaredocumentationresponder.v3.GetCareDocumentationResponseType;
import riv.clinicalprocess.healthcond.description.getcaredocumentationresponder.v3.GetCareDocumentationType;
import riv.clinicalprocess.healthcond.description.v3.ResultType;
import se.skltp.aggregatingservices.AgServiceFactoryBase;

@Log4j2
public class GACD3AgpServiceFactoryImpl extends
    AgServiceFactoryBase<GetCareDocumentationType, GetCareDocumentationResponseType>{

  @Override
  public String getPatientId(GetCareDocumentationType queryObject) {

    // Saknar bättre ställe att göra validering av anropet
    if (queryObject.getHasMoreReference() != null) {
      throw new IllegalArgumentException("Parametern hasMoreReference skall inte användas i anrop till aggregerande tjänst");
    }

    return (queryObject.getPatientId() == null) ? null :queryObject.getPatientId().getExtension();
  }

  @Override
  public String getSourceSystemHsaId(GetCareDocumentationType queryObject) {
    return (queryObject.getSourceSystemId() == null) ? null : queryObject.getSourceSystemId().getExtension();
  }

  @Override
  public GetCareDocumentationResponseType aggregateResponse(List<GetCareDocumentationResponseType> aggregatedResponseList ){

    GetCareDocumentationResponseType aggregatedResponse=new GetCareDocumentationResponseType();

    for (GetCareDocumentationResponseType response : aggregatedResponseList) {
      aggregatedResponse.getCareDocumentation().addAll(response.getCareDocumentation());
      aggregatedResponse.getHasMore().addAll(response.getHasMore());
    }

    ResultType result = new ResultType();
    result.setResultCode(ResultCodeEnum.INFO);
    aggregatedResponse.setResult(result);

    return aggregatedResponse;
  }
}


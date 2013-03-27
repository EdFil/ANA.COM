package pt.ist.anacom.service;

import pt.ist.anacom.domain.Anacom;
import pt.ist.anacom.shared.dto.SMSDto;
import pt.ist.anacom.shared.exception.NoSuchPhoneException;
import pt.ist.anacom.shared.exception.OperatorPrefixDoesNotExistException;
import pt.ist.fenixframework.FenixFramework;

public class ProcessReceiveSMSService extends AnacomService {

    private SMSDto SMSDto;

    public ProcessReceiveSMSService(SMSDto SMSDto) {
        this.SMSDto = SMSDto;
    }

    public final void dispatch() throws NoSuchPhoneException, OperatorPrefixDoesNotExistException {

        Anacom anacom = FenixFramework.getRoot();
        anacom.receiveSMS(SMSDto.getSourcePhoneNumber(), SMSDto.getDestinationPhoneNumber(), SMSDto.getMessage());
    }
}

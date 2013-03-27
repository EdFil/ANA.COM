package pt.ist.anacom.service;

import pt.ist.anacom.domain.Anacom;
import pt.ist.anacom.shared.dto.PhoneDetailedDto;
import pt.ist.anacom.shared.exception.OperatorPrefixDoesNotExistException;
import pt.ist.anacom.shared.exception.PhoneAlreadyExistsException;
import pt.ist.anacom.shared.exception.PhoneAndOperatorPrefixDoNotMatchException;
import pt.ist.anacom.shared.exception.PhoneNumberWrongLengthException;
import pt.ist.fenixframework.FenixFramework;

public class RegisterNewPhoneService extends AnacomService {

    private PhoneDetailedDto phoneDto;

    public RegisterNewPhoneService(PhoneDetailedDto phoneDto) {
        this.phoneDto = phoneDto;
    }

    @Override
    public final void dispatch() throws PhoneAlreadyExistsException,
            PhoneAndOperatorPrefixDoNotMatchException,
            OperatorPrefixDoesNotExistException,
            PhoneNumberWrongLengthException {

        Anacom anacom = FenixFramework.getRoot();
        anacom.addPhone(this.phoneDto.getOperatorPrefix(), this.phoneDto.getPhoneNumber(), this.phoneDto.getPhoneGen());
    }
}

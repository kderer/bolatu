package com.bolatu.web.mobile.util.jsf.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.bolatu.util.I18NUtil;
import com.bolatu.util.StringUtil;

@FacesValidator("retypePasswordValidator")
public class RetypePasswordValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String password = value.toString();

		UIInput confirmPasswordInput = (UIInput) component.getAttributes().get("confirmPasswordField");
		String confirmPassword = confirmPasswordInput.getSubmittedValue().toString();

		if (StringUtil.isNullOrEmpty(password) || StringUtil.isNullOrEmpty(confirmPassword)) {
			return;
		}

		if (!password.equals(confirmPassword)) {
			confirmPasswordInput.setValid(false);
			throw new ValidatorException(
					new FacesMessage(I18NUtil.getMessage("client.message.signup.repasswordnotmach")));
		}
	}

}

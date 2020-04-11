package fudan.se.hardchair.controller.request;

import javax.validation.constraints.NotBlank;

/**
 * @author LBW
 */
public class ConferenceRequest {
    @NotBlank
    private String shortName;
}

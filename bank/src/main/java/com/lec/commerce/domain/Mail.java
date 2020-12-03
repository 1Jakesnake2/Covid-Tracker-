package com.lec.commerce.domain;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Mail {

    private String mailFrom;

    private String mailTo;

    private String mailCc;

    private String mailBcc;

    private String mailSubject;

    private String mailContent;

    private String contentType;

    private List < Object > attachments;

    public Mail() {
        contentType = "text/plain";
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }


    public Date getMailSendDate() {
        return new Date();
    }

    public List < Object > getAttachments() {
        return attachments;
    }

    public void setAttachments(List < Object > attachments) {
        this.attachments = attachments;
    }

}

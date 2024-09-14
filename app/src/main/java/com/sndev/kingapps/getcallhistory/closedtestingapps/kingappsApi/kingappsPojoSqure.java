package com.sndev.kingapps.getcallhistory.closedtestingapps.kingappsApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class kingappsPojoSqure {

    @SerializedName("SN_KING__InAppMode")
    @Expose
    private String cLTagInAppMode;
    @SerializedName("SN_KING__Ticket_Bronze")
    @Expose
    private String cLTagTicketBronze;
    @SerializedName("SN_KING__Ticket_Silver")
    @Expose
    private String cLTagTicketSilver;
    @SerializedName("SN_KING__Ticket_Gold")
    @Expose
    private String cLTagTicketGold;
    @SerializedName("SN_KING__Qureka")
    @Expose
    private String cLTagQureka;
    @SerializedName("SN_KING__GameLink")
    @Expose
    private String cLTagGameLink;
    @SerializedName("SN_KING__MerchantUPI")
    @Expose
    private String cLTagMerchantUPI;
    @SerializedName("SN_KING__MerchantCODE")
    @Expose
    private String cLTagMerchantCODE;
    @SerializedName("SN_KING__Privacy")
    @Expose
    private String cLTagPrivacy;


    public String getCLTagInAppMode() {
        return cLTagInAppMode;
    }

    public void setCLTagInAppMode(String cLTagInAppMode) {
        this.cLTagInAppMode = cLTagInAppMode;
    }

    public String getCLTagTicketBronze() {
        return cLTagTicketBronze;
    }

    public void setCLTagTicketBronze(String cLTagTicketBronze) {
        this.cLTagTicketBronze = cLTagTicketBronze;
    }

    public String getCLTagTicketSilver() {
        return cLTagTicketSilver;
    }

    public void setCLTagTicketSilver(String cLTagTicketSilver) {
        this.cLTagTicketSilver = cLTagTicketSilver;
    }

    public String getCLTagTicketGold() {
        return cLTagTicketGold;
    }

    public void setCLTagTicketGold(String cLTagTicketGold) {
        this.cLTagTicketGold = cLTagTicketGold;
    }

    public String getCLTagQureka() {
        return cLTagQureka;
    }

    public void setCLTagQureka(String cLTagQureka) {
        this.cLTagQureka = cLTagQureka;
    }

    public String getCLTagGameLink() {
        return cLTagGameLink;
    }

    public void setCLTagGameLink(String cLTagGameLink) {
        this.cLTagGameLink = cLTagGameLink;
    }

    public String getCLTagMerchantUPI() {
        return cLTagMerchantUPI;
    }

    public void setCLTagMerchantUPI(String cLTagMerchantUPI) {
        this.cLTagMerchantUPI = cLTagMerchantUPI;
    }

    public String getCLTagMerchantCODE() {
        return cLTagMerchantCODE;
    }

    public void setCLTagMerchantCODE(String cLTagMerchantCODE) {
        this.cLTagMerchantCODE = cLTagMerchantCODE;
    }

    public String getcLTagPrivacy() {
        return cLTagPrivacy;
    }

    public void setcLTagPrivacy(String cLTagPrivacy) {
        this.cLTagPrivacy = cLTagPrivacy;
    }
}
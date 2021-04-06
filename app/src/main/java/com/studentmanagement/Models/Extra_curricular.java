package com.studentmanagement.Models;

public class Extra_curricular {
    String activity,organisation,url,extra_curricular_id;

    public Extra_curricular() {

    }

    public Extra_curricular(String activity, String organisation, String url, String extra_curricular_id) {
        this.activity = activity;
        this.organisation = organisation;
        this.url = url;
        this.extra_curricular_id = extra_curricular_id;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getExtra_curricular_id() {
        return extra_curricular_id;
    }

    public void setExtra_curricular_id(String extra_curricular_id) {
        this.extra_curricular_id = extra_curricular_id;
    }
}

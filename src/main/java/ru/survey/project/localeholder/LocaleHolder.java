package ru.survey.project.localeholder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class LocaleHolder {

    private Locale locale;

    public LocaleHolder(@Value("${locale}")String locale) {
        this.locale = Locale.forLanguageTag(locale);
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = Locale.forLanguageTag(locale);
    }
}

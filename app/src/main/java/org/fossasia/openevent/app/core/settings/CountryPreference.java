package org.fossasia.openevent.app.core.settings;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.preference.DialogPreference;
import android.util.AttributeSet;


import org.fossasia.openevent.app.R;

public class CountryPreference extends DialogPreference {

    private int layoutResourceId = R.layout.dialog_payment_country;
    private int savedIndex;

    public CountryPreference(Context context, AttributeSet attrs) {
        super(context, attrs, R.attr.preferenceStyle);
        setDialogLayoutResource(R.layout.dialog_payment_country);
        setPositiveButtonText(android.R.string.ok);
        setNegativeButtonText(android.R.string.cancel);
        setDialogIcon(null);
    }

    @Override
    protected void onSetInitialValue(boolean restorePersistedValue, Object defaultValue) {
        setCountry(restorePersistedValue ? getPersistedInt(savedIndex) : (int) defaultValue);
        super.onSetInitialValue(restorePersistedValue, defaultValue);
    }

    @Override
    protected Object onGetDefaultValue(TypedArray a, int index) {
        return a.getInt(index, 0);
    }

    public int getCountry() {
        return savedIndex;
    }

    public void setCountry(int index) {
        savedIndex = index;
        persistInt(index);
    }

    public int getDialogLayoutResource() {
        return layoutResourceId;
    }
}

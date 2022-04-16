package com.dizcoding.showcase;


import android.os.Parcel;
import android.os.Parcelable;

public class ShowCaseBuilder implements Parcelable {

    private int layoutRes;
    private int titleTextColorRes;
    private int textColorRes;
    private int shadowColorRes;
    private int titleTextSizeRes;
    private int textSizeRes;
    private int spacingRes;
    private int backgroundContentColorRes;
    private int circleIndicatorBackgroundDrawableRes;
    private int prevDrawableRes;
    private int nextDrawableRes;
    private int finishDrawableRes;
    private boolean useCircleIndicator = true;
    private boolean clickable = false;
    private boolean useArrow = true;
    private int arrowWidth;
    private String packageName;

    private int skipDrawableRes;
    private int lineColorRes;
    private boolean useSkipWord;

    public ShowCaseBuilder setPackageName(String packageName) {
        this.packageName = packageName;
        return this;
    }

    public ShowCaseBuilder customView(int customViewRes) {
        this.layoutRes = customViewRes;
        return this;
    }

    public ShowCaseBuilder textColorRes(int textColorRes) {
        this.textColorRes = textColorRes;
        return this;
    }

    public ShowCaseBuilder titleTextColorRes(int titleTextColorRes) {
        this.titleTextColorRes = titleTextColorRes;
        return this;
    }

    public ShowCaseBuilder shadowColorRes(int shadowColorRes) {
        this.shadowColorRes = shadowColorRes;
        return this;
    }

    public ShowCaseBuilder useArrow(boolean useArrow) {
        this.useArrow = useArrow;
        return this;
    }

    public ShowCaseBuilder useSkipWord(boolean useSkipWord) {
        this.useSkipWord = useSkipWord;
        return this;
    }

    public ShowCaseBuilder textSizeRes(int textSizeRes) {
        this.textSizeRes = textSizeRes;
        return this;
    }

    public ShowCaseBuilder titleTextSizeRes(int titleTextSizeRes) {
        this.titleTextSizeRes = titleTextSizeRes;
        return this;
    }

    public ShowCaseBuilder spacingRes(int spacingRes) {
        this.spacingRes = spacingRes;
        return this;
    }

    public ShowCaseBuilder arrowWidth(int arrowWidth) {
        this.arrowWidth = arrowWidth;
        return this;
    }

    public ShowCaseBuilder backgroundContentColorRes(int backgroundContentColorRes) {
        this.backgroundContentColorRes = backgroundContentColorRes;
        return this;
    }

    public ShowCaseBuilder circleIndicatorBackgroundDrawableRes(int circleIndicatorBackgroundDrawableRes) {
        this.circleIndicatorBackgroundDrawableRes = circleIndicatorBackgroundDrawableRes;
        return this;
    }

    public ShowCaseBuilder setLineColorRes(int lineColorRes) {
        this.lineColorRes = lineColorRes;
        return this;
    }

    public ShowCaseBuilder finishDrawableRes(int finishDrawableRes) {
        this.finishDrawableRes = finishDrawableRes;
        return this;
    }

    public ShowCaseBuilder prevDrawableRes(int prevDrawableRes) {
        this.prevDrawableRes = prevDrawableRes;
        return this;
    }

    public ShowCaseBuilder nextDrawableRes(int nextDrawableRes) {
        this.nextDrawableRes = nextDrawableRes;
        return this;
    }

    public ShowCaseBuilder skipDrawableRes(int skipDrawableRes) {
        this.skipDrawableRes = skipDrawableRes;
        return this;
    }


    public ShowCaseBuilder clickable(boolean clickable) {
        this.clickable = clickable;
        return this;
    }

    public ShowCaseBuilder useCircleIndicator(boolean useCircleIndicator) {
        this.useCircleIndicator = useCircleIndicator;
        return this;
    }

    public String getPackageName() {
        return packageName;
    }
    public int getLineColorRes() {
        return lineColorRes;
    }

    public int getTextColorRes() {
        return textColorRes;
    }

    public int getTitleTextColorRes() {
        return titleTextColorRes;
    }

    public int getTitleTextSizeRes() {
        return titleTextSizeRes;
    }

    public int getFinishDrawableRes() {
        return finishDrawableRes;
    }

    public int getNextDrawableRes() {
        return nextDrawableRes;
    }

    public int getSkipDrawableRes() {
        return skipDrawableRes;
    }

    public int getPrevDrawableRes() {
        return prevDrawableRes;
    }

    public boolean useCircleIndicator() {
        return useCircleIndicator;
    }

    public int getShadowColorRes() {
        return shadowColorRes;
    }

    public int getTextSizeRes() {
        return textSizeRes;
    }

    public int getBackgroundContentColorRes() {
        return backgroundContentColorRes;
    }

    public int getCircleIndicatorBackgroundDrawableRes() {
        return circleIndicatorBackgroundDrawableRes;
    }

    public boolean isUseArrow() {
        return useArrow;
    }

    public boolean isUseSkipWord(){
        return useSkipWord;
    }

    public int getLayoutRes() {
        return layoutRes;
    }

    public int getArrowWidth() {
        return arrowWidth;
    }

    public int getSpacingRes() {
        return spacingRes;
    }

    public boolean isClickable() {
        return clickable;
    }

    public ShowCaseDialog build() {
        return ShowCaseDialog.newInstance(this);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.layoutRes);
        dest.writeInt(this.titleTextColorRes);
        dest.writeInt(this.textColorRes);
        dest.writeInt(this.shadowColorRes);
        dest.writeInt(this.titleTextSizeRes);
        dest.writeInt(this.textSizeRes);
        dest.writeInt(this.spacingRes);
        dest.writeInt(this.backgroundContentColorRes);
        dest.writeInt(this.circleIndicatorBackgroundDrawableRes);
        dest.writeInt(this.prevDrawableRes);
        dest.writeInt(this.nextDrawableRes);
        dest.writeInt(this.finishDrawableRes);
        dest.writeByte(this.useCircleIndicator ? (byte) 1 : (byte) 0);
        dest.writeByte(this.clickable ? (byte) 1 : (byte) 0);
        dest.writeByte(this.useArrow ? (byte) 1 : (byte) 0);
        dest.writeInt(this.arrowWidth);
        dest.writeInt(this.skipDrawableRes);
        dest.writeInt(this.lineColorRes);
        dest.writeByte(this.useSkipWord ? (byte) 1 : (byte) 0);
    }

    public ShowCaseBuilder() {
    }

    protected ShowCaseBuilder(Parcel in) {
        this.layoutRes = in.readInt();
        this.titleTextColorRes = in.readInt();
        this.textColorRes = in.readInt();
        this.shadowColorRes = in.readInt();
        this.titleTextSizeRes = in.readInt();
        this.textSizeRes = in.readInt();
        this.spacingRes = in.readInt();
        this.backgroundContentColorRes = in.readInt();
        this.circleIndicatorBackgroundDrawableRes = in.readInt();
        this.prevDrawableRes = in.readInt();
        this.nextDrawableRes = in.readInt();
        this.finishDrawableRes = in.readInt();
        this.useCircleIndicator = in.readByte() != 0;
        this.clickable = in.readByte() != 0;
        this.useArrow = in.readByte() != 0;
        this.arrowWidth = in.readInt();
        this.skipDrawableRes = in.readInt();
        this.lineColorRes = in.readInt();
        this.useSkipWord = in.readByte() != 0;
    }

    public static final Creator<ShowCaseBuilder> CREATOR = new Creator<ShowCaseBuilder>() {
        @Override
        public ShowCaseBuilder createFromParcel(Parcel source) {
            return new ShowCaseBuilder(source);
        }

        @Override
        public ShowCaseBuilder[] newArray(int size) {
            return new ShowCaseBuilder[size];
        }
    };
}


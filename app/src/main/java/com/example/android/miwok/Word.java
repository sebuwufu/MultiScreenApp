package com.example.android.miwok;

/**
 * Created by Patu on 11/11/2017.
 */
    public class Word {
        private String mDefaultTranslation;
        private String mLugandaTranslation;
        private int mImageResourceId;
        private int mSoundResourceId;
        private boolean mHasImage;


        //@param mDefaultTranslation: will contain the English word
        //@param mLugandaTranslation: will contain the Luganda meaning of the word.

        public Word(String defaultTranslation, String LugandaTranslation){
            mDefaultTranslation = defaultTranslation;
            mLugandaTranslation = LugandaTranslation;
            mHasImage=false;
        }

        public Word(String defaultTranslation, String LugandaTranslation, int soundResource){
            mDefaultTranslation = defaultTranslation;
            mLugandaTranslation = LugandaTranslation;
            mSoundResourceId=soundResource;
            mHasImage=false;
        }

    public Word(String defaultTranslation, String LugandaTranslation, int soundResource, int ImageId){
        mDefaultTranslation = defaultTranslation;
        mLugandaTranslation = LugandaTranslation;
        mSoundResourceId = soundResource;
        mImageResourceId = ImageId;
        mHasImage=true;
    }


    public String getLugandaTranslation() {
        return mLugandaTranslation;
    }
    public String getDefaultTranslation(){ return mDefaultTranslation; }
    public int getImageResourceId() {return mImageResourceId; }
    public boolean getHasImage(){return mHasImage;}
    public int getSoundResourceId(){return mSoundResourceId;}

}

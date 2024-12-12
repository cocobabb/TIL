package org.example;

public class Mp3Player {
    String modelName;
    int volume;
    boolean onOff;

    public Mp3Player(String modelName) {
        this.modelName = modelName;
        this.volume = 0;
        this.onOff = false;
    }

    public boolean pushPowerBtn(){
        if(onOff){
            return this.turnOff();
        }else {
            return this.turnOn();
        }
    }

    public boolean turnOn(){
        if(!this.onOff){
            this.onOff = true;
            this.volume = 40;
        }
//        전원 버튼 눌렀을 때 켜져있으면 키고 꺼져있으면 키는 기능
//        else if (this.onOff) {
//            this.turnOff();
//        }
        return this.onOff;
    }

    public boolean turnOff(){
        if(this.onOff){
            this.onOff = false;
            this.volume = 0;
        }
//        전원 버튼 눌렀을 때 켜져있으면 키고 꺼져있으면 키는 기능
//        else if (!this.onOff) {
//            this.turnOn();
//        }
        return this.onOff;
    }

    public void increaseVolume(){
        if(this.onOff && this.volume < 100){
            this.volume += 20;
        }
    }
    public void decreaseVolume(){
        if(this.onOff && this.volume != 0){
            this.volume -= 20;
        }
    }
    public void showPlayerInfo(){
        System.out.println("modelName: " + modelName);
        System.out.println("volume = " + volume);
        System.out.println("onOff = " + onOff);
    }
}

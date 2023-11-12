package christmas.enums;

public enum OutputMessage {
    DISPLAY_VISIT_DATE("일에 우테코 식당에서 받을 이벤트 헤택 미리 보기!");

    String message;
    OutputMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}

package org.example;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
//@Getter
//@Setter

public class StudentPojo {
    public  int restId =0;
    public  int kafkaId =0;
    public  int rabbitId =0;
    public  int camelId =0;
//    private static int restId;
    public  String name;

//    public StudentPojo(String name) {
//        this.name = name;
//    }

    @Override
    public String toString() {
        return "StudentPojo{" +"\n"+
                "name='" + name + '\'' +"\n"+
                "restId='" + restId + '\'' +"\n"+
                "kafkaId='" + kafkaId + '\'' +"\n"+
                "rabbitId='" + rabbitId + '\'' +"\n"+
                "camelId='" + camelId + '\'' +
                '}';
    }
}

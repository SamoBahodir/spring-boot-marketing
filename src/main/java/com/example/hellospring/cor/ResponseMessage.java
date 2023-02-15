package com.example.hellospring.cor;

import com.example.hellospring.cor.constant.MessageType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessage {
    private MessageType type;
    private Name message;
}

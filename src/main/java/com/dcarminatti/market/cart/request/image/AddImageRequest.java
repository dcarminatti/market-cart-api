package com.dcarminatti.market.cart.request.image;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class AddImageRequest {
    List<MultipartFile> images;
}

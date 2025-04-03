package com.dcarminatti.market.cart.service.image;

import com.dcarminatti.market.cart.dto.ImageDto;
import com.dcarminatti.market.cart.model.Image;
import com.dcarminatti.market.cart.request.image.AddImageRequest;
import com.dcarminatti.market.cart.request.image.ImageUpdateRequest;

import java.util.List;

public interface IImageService {
    List<ImageDto> addImages(AddImageRequest request, Long productId);
    Image getImageById(Long imageId);
    Image updateImage(ImageUpdateRequest request, Long imageId);
    void deleteImageById(Long imageId);
}

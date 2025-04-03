package com.dcarminatti.market.cart.service.image;

import com.dcarminatti.market.cart.dto.ImageDto;
import com.dcarminatti.market.cart.exception.image.FailedSaveImageException;
import com.dcarminatti.market.cart.exception.image.FailedUpdateImageException;
import com.dcarminatti.market.cart.exception.image.ImageNotFoundException;
import com.dcarminatti.market.cart.model.Image;
import com.dcarminatti.market.cart.model.Product;
import com.dcarminatti.market.cart.repository.ImageRepository;
import com.dcarminatti.market.cart.request.image.AddImageRequest;
import com.dcarminatti.market.cart.request.image.ImageUpdateRequest;
import com.dcarminatti.market.cart.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService implements IImageService{
    private final ImageRepository imageRepository;
    private final ProductService productService;

    public List<ImageDto> addImages(AddImageRequest request, Long productId) {
        Product product = productService.getProductById(productId);
        List<ImageDto> imageDtoList = new ArrayList<>();

        for (MultipartFile file : request.getImages()) {
            ImageDto imageDto = createImage(file, product);
            imageDtoList.add(imageDto);
        }

        return imageDtoList;
    }

    private ImageDto createImage(MultipartFile file, Product product) {
        try {
            Image image = new Image();
            image.setFileName(file.getOriginalFilename());
            image.setFileType(file.getContentType());
            image.setImage(new SerialBlob(file.getBytes()));
            image.setProduct(product);

            String buildDownloadUrl = "/api/v1/images/image/download/";
            String downloadUrl = buildDownloadUrl + image.getId();
            image.setDownloadUrl(downloadUrl);

            Image savedImage = imageRepository.save(image);
            downloadUrl = buildDownloadUrl + savedImage.getId();
            savedImage.setDownloadUrl(downloadUrl);
            imageRepository.save(savedImage);

            ImageDto imageDto = new ImageDto();
            imageDto.setId(savedImage.getId());
            imageDto.setFileName(savedImage.getFileName());
            imageDto.setDownloadUrl(downloadUrl);

            return imageDto;
        } catch (Exception ex) {
            throw new FailedSaveImageException("Failed to save image: " + ex.getMessage(), ex.getCause());
        }
    }

    public Image getImageById(Long imageId) {
        return imageRepository.findById(imageId).orElseThrow(() -> new ImageNotFoundException("Image not found!"));
    }

    public Image updateImage(ImageUpdateRequest request, Long imageId) {
        return imageRepository.findById(imageId)
                .map(existingImage -> updateExistingImage(request, existingImage))
                .map(imageRepository::save)
                .orElseThrow(() -> new ImageNotFoundException("Image not found!"));
    }

    private Image updateExistingImage(ImageUpdateRequest request, Image existingImage) {
        try {
            existingImage.setFileName(request.getOriginalFilename());
            existingImage.setFileType(request.getContentType());
            existingImage.setImage(new SerialBlob(request.getBytes()));
            return existingImage;
        } catch (Exception e) {
            throw new FailedUpdateImageException("Failed to update image: " + e.getMessage(), e.getCause());
        }
    }

    public void deleteImageById(Long imageId) {
        imageRepository.findById(imageId).ifPresentOrElse(imageRepository::delete, () -> {
            throw new ImageNotFoundException("Image not found!");
        });
    }
}

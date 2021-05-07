import com.sapient.poc.entity.BrandEntity
import com.sapient.poc.entity.CategoryEntity
import com.sapient.poc.entity.ColorEntity
import com.sapient.poc.entity.Product
import com.sapient.poc.entity.SellerEntity
import com.sapient.poc.exceptions.ProductNotFoundException
import com.sapient.poc.repositories.ProductRepository
import com.sapient.poc.service.ProductService
import com.sapient.poc.service.ProductServiceImpl
import spock.lang.Specification

class ProductServiceTest extends Specification{

    ProductRepository productRepository = Mock();
    ProductService productService = new ProductServiceImpl(productRepository);


    def "list product success"() {
        given:
        productRepository.findAll() >> createListProductsResponse()
        when:
        def result = productService.getAllProduct()
        then:
        result.size() > 0

    }


    def "list product failure"() {
        given:
        productRepository.findAll() >> new ArrayList<Product>()
        when:
        def result = productService.getAllProduct()
        then:
        result.size() == 0

    }

    def "update product failure"(){
        given:
        productRepository.findById(_) >> new Optional<>()
        Product product = Stub(Product.class)
        when:
        def result = productService.updateProducts(product)
        then:
        thrown(ProductNotFoundException)

    }





    private static List<Product> createListProductsResponse() {
        ArrayList<Product> list = new ArrayList<>();
        CategoryEntity categoryEntity2 = new CategoryEntity("Socks");
        CategoryEntity categoryEntity3 = new CategoryEntity("Shirt");
        CategoryEntity categoryEntity4 = new CategoryEntity("Denim");

        BrandEntity brandEntity = new BrandEntity("Levis");
        BrandEntity brandEntity1 = new BrandEntity("UCB");
        BrandEntity brandEntity2 = new BrandEntity("CK");

        ColorEntity colorEntity2 = new ColorEntity("YELLOW");
        ColorEntity colorEntity3 = new ColorEntity("ORANGE");

        SellerEntity sellerEntity = new SellerEntity("JOHN & SONS");
        SellerEntity sellerEntity1 = new SellerEntity("ROHAN & SONS");
        SellerEntity sellerEntity2 = new SellerEntity("PETR & SONS");

        list.add(new Product("Shirt Blue","BLUE SHIRT WIT STIPE", BigDecimal.valueOf(12233.99),sellerEntity2,categoryEntity4,colorEntity3,brandEntity1));
        list.add(new Product("YELLOW Blue","BLUE SHIRT WIT STIPE",BigDecimal.valueOf(123233.99),sellerEntity1,categoryEntity2,colorEntity2,brandEntity2));
        list.add(new Product("SOCKS","BLUE SHIRT WIT STIPE",BigDecimal.valueOf(1233.99),sellerEntity,categoryEntity3,colorEntity2,brandEntity));

        return list;
    }

}

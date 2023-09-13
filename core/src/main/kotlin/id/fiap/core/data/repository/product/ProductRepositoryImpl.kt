package id.fiap.core.data.repository.product


import id.fiap.core.data.model.Product
import id.fiap.core.domain.repository.product.ProductRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepositoryImpl @Inject constructor() : ProductRepository {
    override fun getProductsApiCall(): MutableList<Product> {

        return mutableListOf(
            Product(
                id = 1,
                category = "Marmitas",
                title = "Marmita de Frango",
                price = 20,
                description = "Marmita 1",
                size = 1,
                thumbnail = "https://cdn.pixabay.com/photo/2017/04/28/16/41/the-pan-2268825_1280.png",
            ),
            Product(
                id = 2,
                category = "Marmitas",
                title = "Marmita Vegetariana",
                price = 18,
                description = "Marmita 2",
                size = 2,
                thumbnail = "https://marmitexdesucesso.com/wp-content/uploads/2021/07/como-fazer-marmitex-vegetariano-para-vender.jpg",
            ),
            Product(
                id = 3,
                category = "Marmitas",
                title = "Marmita de Carne",
                price = 22,
                description = "Marmita 3",
                size = 1,
                thumbnail = "https://media.istockphoto.com/id/1300336353/pt/foto/marmita-or-marmitex-meal-to-take-food-in-the-box.jpg?s=612x612&w=0&k=20&c=wBkGduOttntNPw1_bSs7VhMEMfL6FlCYidnXF2IojHg=",
            ),
            Product(
                id = 4,
                category = "Marmitas",
                title = "Marmita Vegana",
                price = 20,
                description = "Marmita 4",
                size = 2,
                thumbnail = "https://storage.googleapis.com/domain-images/1718aa29-f3d5-4e6f-b968-65b2f0ff745c/products/gallery_a9e3d18c-1bd4-46f4-b617-7fdfd5598211.jpeg",
            ),
            Product(
                id = 5,
                category = "Marmitas",
                title = "Marmita de Peixe",
                price = 21,
                description = "Marmita 5",
                size = 1,
                thumbnail = "https://yata.s3-object.locaweb.com.br/f024f4b5e199588393bc1127e62c4e94cae25f0c5a2a59bda9ef374140dd6c42",
            ),
            Product(
                id = 6,
                category = "Marmitas",
                title = "Marmita de Bisteca",
                price = 20,
                description = "Marmita 6",
                size = 2,
                thumbnail = "https://static.wixstatic.com/media/b617de_8045e6435b2c4bb6858ffc2f26f76166~mv2.png/v1/crop/x_471,y_470,w_4708,h_3953/fill/w_308,h_260,al_c,q_85,usm_0.66_1.00_0.01,enc_auto/MARMITA_01.png",
            ),
            Product(
                id = 7,
                category = "Marmitas",
                title = "Marmita de Carne",
                price = 25,
                description = "Marmita 7",
                size = 1,
                thumbnail = "https://t3.ftcdn.net/jpg/05/31/49/32/360_F_531493238_YOdY3Y4xLpPgHMxo3zegSxl1DgJOsr4k.jpg",
            ),
            Product(
                id = 8,
                category = "Marmitas",
                title = "Marmita de Polenta",
                price = 19,
                description = "Marmita 8",
                size = 2,
                thumbnail = "https://media.istockphoto.com/id/1300336114/pt/foto/marmita-or-marmitex-meal-to-take-food-in-the-box.jpg?s=612x612&w=0&k=20&c=ciBtXQ3Uvbug76xQELgCX4iVexVC7l8amGA7LF9JX5c=",
            ),
            Product(
                id = 9,
                category = "Marmitas",
                title = "Marmita Parmegiana",
                price = 22,
                description = "Marmita 9",
                size = 1,
                thumbnail = "https://static.ifood-static.com.br/image/upload/t_medium/pratos/9a9fcef3-1f75-477c-9c6d-00e935e588b8/202110041659_0083_i.jpg",
            ),
            Product(
                id = 10,
                category = "Marmitas",
                title = "Marmita de Churrasco",
                price = 25,
                description = "Marmita 10",
                size = 2,
                thumbnail = "https://talentlicita.com.br/wp-content/uploads/2021/02/Como-montar-seu-negocio-de-delivery-de-marmitex-imagem4-SAIPOS-sistema-para-restaurantes.jpg",
            )
        )
    }

}
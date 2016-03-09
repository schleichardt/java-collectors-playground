import io.sphere.sdk.json.SphereJsonUtils;
import io.sphere.sdk.products.ProductProjection;
import io.sphere.sdk.products.queries.ProductProjectionQuery;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Locale.ENGLISH;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class CollectorsTest {
    private static List<ProductProjection> productList = SphereJsonUtils.readObjectFromResource("productsQueryResult.json", ProductProjectionQuery.resultTypeReference()).getResults();

    @Test
    public void joining() {
        assertThat(productList.toString()).hasSize(2003954);
        //that is too long to understand, we need to reduce the amount of dats

        final String pureJoining = productList.stream()
                //we reduce the amount of data by just getting the English name
                .map(product -> product.getName().get(ENGLISH))
                .collect(Collectors.joining());

        assertThat(pureJoining).isEqualTo("#maximilianlook 12#maximilianlook 3Our exQuisite Corpse - Skull “Santos Green”#maximilianlook 19#maximilianlook 5#maximilianlook 7#maximilianlook 32#maximilianlook 6#maximilianlook 15#maximilianlook 15#maximilianlook 20#maximilianlook 24#maximilianlook 3Profanter – Bag “Helen”Profanter – Bag “Helen”#maximilianlook 45Guess – Hand bag “Privacy“#maximilianlook 14Guess – Handbag#maximilianlook 21#maximilianlook 62#maximilianlook 70Happiness – T- ShirtLe Pandorine – Shopper “Shopper 71”Zanellato – Bag “Chianti”#maximilianlook 28#maximilianlook 25#maximilianlook 28#maximilianlook 5#maximilianlook 4#maximilianlook 11#maximilianlook 11#maximilianlook 16#maximilianlook 16#maximilianlook 22#maximilianlook 21#maximilianlook 31#maximilianlook 17#maximilianlook 18Guess – Handbag “Greyson“Profanter – Bucket Bag “Olivia”Codello - Scarf “I MOG DI!”#maximilianlook 34Majestic Filatures – TurtleneckJucca – Knit SweaterHappiness - Sweat- JacketGuess – Bag “Aliza”Closed – Jeans „Worker X”Save my Bag - Handbag \"Kaki\"Moncler – Down Vest “Dupres”Moncler – SweaterLiu Jo – ClutchAltea – ScarfLis Lab – BlazerGuess – ScarfJucca - SweaterLe Pandorine - HandbagLe Pandorine - HandbagLe Pandorine - HandbagSave the Duck – Casual Jacket \"Sold\"Luis Trenker – Casual Jacket \"Stuart\"Liu Jo - Bag#maximilianlook 102Chamonix – Casual Jacket \"Fabrice\"Save my Bag - Handbag \"Port\"Michael Kors – Bag “Selma”Michael Kors –Bag “Hamilton”Michael Kors –Bag “Harper”#maximilianlook 27#maximilianlook 32#maximilianlook 29#maximilianlook 30#maximilianlook 48#maximilianlook 50Michael Kors – PoloOakwood – CapeAltea – ScarfBelt – Guess “Lea“ Profanter – Bucket Bag “Olivia”Moncler – Down Jacket “Rodin”Moncler – Down Jacket “Vallier”Moncler – Down Jacket “Ryan”Moncler – Down Jacket “Jacob”Our exQuisite Corpse - Skull “Santos Brown”Our exQuisite Corpse - Skull “Geometr Blu”Guess – Shopper “Audrey”360 Sweater – SweaterGolden Goose – T-ShirtGuess – ScarfLe Pandorine - Bag Happiness - Sweatpants \"Turca Strass\"Maison Scotch - Hat#maximilianlook 6#maximilianlook 9Profanter – Bag “Tina”Profanter – Bag “Tina”#maximilianlook 46#maximilianlook 49Etro – ScarfGabs – Bag “Sofia”");
        //here is nothing special because we could also do this:

        final List<String> englishNamesList = productList.stream()
                .map(product -> product.getName().get(ENGLISH))
                .collect(toList());
        assertThat(englishNamesList.toString()).isEqualTo("[#maximilianlook 12, #maximilianlook 3, Our exQuisite Corpse - Skull “Santos Green”, #maximilianlook 19, #maximilianlook 5, #maximilianlook 7, #maximilianlook 32, #maximilianlook 6, #maximilianlook 15, #maximilianlook 15, #maximilianlook 20, #maximilianlook 24, #maximilianlook 3, Profanter – Bag “Helen”, Profanter – Bag “Helen”, #maximilianlook 45, Guess – Hand bag “Privacy“, #maximilianlook 14, Guess – Handbag, #maximilianlook 21, #maximilianlook 62, #maximilianlook 70, Happiness – T- Shirt, Le Pandorine – Shopper “Shopper 71”, Zanellato – Bag “Chianti”, #maximilianlook 28, #maximilianlook 25, #maximilianlook 28, #maximilianlook 5, #maximilianlook 4, #maximilianlook 11, #maximilianlook 11, #maximilianlook 16, #maximilianlook 16, #maximilianlook 22, #maximilianlook 21, #maximilianlook 31, #maximilianlook 17, #maximilianlook 18, Guess – Handbag “Greyson“, Profanter – Bucket Bag “Olivia”, Codello - Scarf “I MOG DI!”, #maximilianlook 34, Majestic Filatures – Turtleneck, Jucca – Knit Sweater, Happiness - Sweat- Jacket, Guess – Bag “Aliza”, Closed – Jeans „Worker X”, Save my Bag - Handbag \"Kaki\", Moncler – Down Vest “Dupres”, Moncler – Sweater, Liu Jo – Clutch, Altea – Scarf, Lis Lab – Blazer, Guess – Scarf, Jucca - Sweater, Le Pandorine - Handbag, Le Pandorine - Handbag, Le Pandorine - Handbag, Save the Duck – Casual Jacket \"Sold\", Luis Trenker – Casual Jacket \"Stuart\", Liu Jo - Bag, #maximilianlook 102, Chamonix – Casual Jacket \"Fabrice\", Save my Bag - Handbag \"Port\", Michael Kors – Bag “Selma”, Michael Kors –Bag “Hamilton”, Michael Kors –Bag “Harper”, #maximilianlook 27, #maximilianlook 32, #maximilianlook 29, #maximilianlook 30, #maximilianlook 48, #maximilianlook 50, Michael Kors – Polo, Oakwood – Cape, Altea – Scarf, Belt – Guess “Lea“ , Profanter – Bucket Bag “Olivia”, Moncler – Down Jacket “Rodin”, Moncler – Down Jacket “Vallier”, Moncler – Down Jacket “Ryan”, Moncler – Down Jacket “Jacob”, Our exQuisite Corpse - Skull “Santos Brown”, Our exQuisite Corpse - Skull “Geometr Blu”, Guess – Shopper “Audrey”, 360 Sweater – Sweater, Golden Goose – T-Shirt, Guess – Scarf, Le Pandorine - Bag , Happiness - Sweatpants \"Turca Strass\", Maison Scotch - Hat, #maximilianlook 6, #maximilianlook 9, Profanter – Bag “Tina”, Profanter – Bag “Tina”, #maximilianlook 46, #maximilianlook 49, Etro – Scarf, Gabs – Bag “Sofia”]");
        //this was nicer because of the comma, but it requires too much scrolling to the right

        final String withLineFeedDelimiter = productList.stream()
                .map(product -> product.getName().get(ENGLISH))
                .collect(Collectors.joining("\n"));
        assertThat(withLineFeedDelimiter).isEqualTo("#maximilianlook 12\n" +
                "#maximilianlook 3\n" +
                "Our exQuisite Corpse - Skull “Santos Green”\n" +
                "#maximilianlook 19\n" +
                "#maximilianlook 5\n" +
                "#maximilianlook 7\n" +
                "#maximilianlook 32\n" +
                "#maximilianlook 6\n" +
                "#maximilianlook 15\n" +
                "#maximilianlook 15\n" +
                "#maximilianlook 20\n" +
                "#maximilianlook 24\n" +
                "#maximilianlook 3\n" +
                "Profanter – Bag “Helen”\n" +
                "Profanter – Bag “Helen”\n" +
                "#maximilianlook 45\n" +
                "Guess – Hand bag “Privacy“\n" +
                "#maximilianlook 14\n" +
                "Guess – Handbag\n" +
                "#maximilianlook 21\n" +
                "#maximilianlook 62\n" +
                "#maximilianlook 70\n" +
                "Happiness – T- Shirt\n" +
                "Le Pandorine – Shopper “Shopper 71”\n" +
                "Zanellato – Bag “Chianti”\n" +
                "#maximilianlook 28\n" +
                "#maximilianlook 25\n" +
                "#maximilianlook 28\n" +
                "#maximilianlook 5\n" +
                "#maximilianlook 4\n" +
                "#maximilianlook 11\n" +
                "#maximilianlook 11\n" +
                "#maximilianlook 16\n" +
                "#maximilianlook 16\n" +
                "#maximilianlook 22\n" +
                "#maximilianlook 21\n" +
                "#maximilianlook 31\n" +
                "#maximilianlook 17\n" +
                "#maximilianlook 18\n" +
                "Guess – Handbag “Greyson“\n" +
                "Profanter – Bucket Bag “Olivia”\n" +
                "Codello - Scarf “I MOG DI!”\n" +
                "#maximilianlook 34\n" +
                "Majestic Filatures – Turtleneck\n" +
                "Jucca – Knit Sweater\n" +
                "Happiness - Sweat- Jacket\n" +
                "Guess – Bag “Aliza”\n" +
                "Closed – Jeans „Worker X”\n" +
                "Save my Bag - Handbag \"Kaki\"\n" +
                "Moncler – Down Vest “Dupres”\n" +
                "Moncler – Sweater\n" +
                "Liu Jo – Clutch\n" +
                "Altea – Scarf\n" +
                "Lis Lab – Blazer\n" +
                "Guess – Scarf\n" +
                "Jucca - Sweater\n" +
                "Le Pandorine - Handbag\n" +
                "Le Pandorine - Handbag\n" +
                "Le Pandorine - Handbag\n" +
                "Save the Duck – Casual Jacket \"Sold\"\n" +
                "Luis Trenker – Casual Jacket \"Stuart\"\n" +
                "Liu Jo - Bag\n" +
                "#maximilianlook 102\n" +
                "Chamonix – Casual Jacket \"Fabrice\"\n" +
                "Save my Bag - Handbag \"Port\"\n" +
                "Michael Kors – Bag “Selma”\n" +
                "Michael Kors –Bag “Hamilton”\n" +
                "Michael Kors –Bag “Harper”\n" +
                "#maximilianlook 27\n" +
                "#maximilianlook 32\n" +
                "#maximilianlook 29\n" +
                "#maximilianlook 30\n" +
                "#maximilianlook 48\n" +
                "#maximilianlook 50\n" +
                "Michael Kors – Polo\n" +
                "Oakwood – Cape\n" +
                "Altea – Scarf\n" +
                "Belt – Guess “Lea“ \n" +
                "Profanter – Bucket Bag “Olivia”\n" +
                "Moncler – Down Jacket “Rodin”\n" +
                "Moncler – Down Jacket “Vallier”\n" +
                "Moncler – Down Jacket “Ryan”\n" +
                "Moncler – Down Jacket “Jacob”\n" +
                "Our exQuisite Corpse - Skull “Santos Brown”\n" +
                "Our exQuisite Corpse - Skull “Geometr Blu”\n" +
                "Guess – Shopper “Audrey”\n" +
                "360 Sweater – Sweater\n" +
                "Golden Goose – T-Shirt\n" +
                "Guess – Scarf\n" +
                "Le Pandorine - Bag \n" +
                "Happiness - Sweatpants \"Turca Strass\"\n" +
                "Maison Scotch - Hat\n" +
                "#maximilianlook 6\n" +
                "#maximilianlook 9\n" +
                "Profanter – Bag “Tina”\n" +
                "Profanter – Bag “Tina”\n" +
                "#maximilianlook 46\n" +
                "#maximilianlook 49\n" +
                "Etro – Scarf\n" +
                "Gabs – Bag “Sofia”");

        final String withStartAndEnd = productList.stream()
                .map(product -> product.getName().get(ENGLISH))
                .collect(Collectors.joining("</li>\n\t<li>", "<ul>\n\t<li>", "</li>\n</ul>"));
        //export it to HTML without template engine
        assertThat(withStartAndEnd).isEqualTo("<ul>\n" +
                "\t<li>#maximilianlook 12</li>\n" +
                "\t<li>#maximilianlook 3</li>\n" +
                "\t<li>Our exQuisite Corpse - Skull “Santos Green”</li>\n" +
                "\t<li>#maximilianlook 19</li>\n" +
                "\t<li>#maximilianlook 5</li>\n" +
                "\t<li>#maximilianlook 7</li>\n" +
                "\t<li>#maximilianlook 32</li>\n" +
                "\t<li>#maximilianlook 6</li>\n" +
                "\t<li>#maximilianlook 15</li>\n" +
                "\t<li>#maximilianlook 15</li>\n" +
                "\t<li>#maximilianlook 20</li>\n" +
                "\t<li>#maximilianlook 24</li>\n" +
                "\t<li>#maximilianlook 3</li>\n" +
                "\t<li>Profanter – Bag “Helen”</li>\n" +
                "\t<li>Profanter – Bag “Helen”</li>\n" +
                "\t<li>#maximilianlook 45</li>\n" +
                "\t<li>Guess – Hand bag “Privacy“</li>\n" +
                "\t<li>#maximilianlook 14</li>\n" +
                "\t<li>Guess – Handbag</li>\n" +
                "\t<li>#maximilianlook 21</li>\n" +
                "\t<li>#maximilianlook 62</li>\n" +
                "\t<li>#maximilianlook 70</li>\n" +
                "\t<li>Happiness – T- Shirt</li>\n" +
                "\t<li>Le Pandorine – Shopper “Shopper 71”</li>\n" +
                "\t<li>Zanellato – Bag “Chianti”</li>\n" +
                "\t<li>#maximilianlook 28</li>\n" +
                "\t<li>#maximilianlook 25</li>\n" +
                "\t<li>#maximilianlook 28</li>\n" +
                "\t<li>#maximilianlook 5</li>\n" +
                "\t<li>#maximilianlook 4</li>\n" +
                "\t<li>#maximilianlook 11</li>\n" +
                "\t<li>#maximilianlook 11</li>\n" +
                "\t<li>#maximilianlook 16</li>\n" +
                "\t<li>#maximilianlook 16</li>\n" +
                "\t<li>#maximilianlook 22</li>\n" +
                "\t<li>#maximilianlook 21</li>\n" +
                "\t<li>#maximilianlook 31</li>\n" +
                "\t<li>#maximilianlook 17</li>\n" +
                "\t<li>#maximilianlook 18</li>\n" +
                "\t<li>Guess – Handbag “Greyson“</li>\n" +
                "\t<li>Profanter – Bucket Bag “Olivia”</li>\n" +
                "\t<li>Codello - Scarf “I MOG DI!”</li>\n" +
                "\t<li>#maximilianlook 34</li>\n" +
                "\t<li>Majestic Filatures – Turtleneck</li>\n" +
                "\t<li>Jucca – Knit Sweater</li>\n" +
                "\t<li>Happiness - Sweat- Jacket</li>\n" +
                "\t<li>Guess – Bag “Aliza”</li>\n" +
                "\t<li>Closed – Jeans „Worker X”</li>\n" +
                "\t<li>Save my Bag - Handbag \"Kaki\"</li>\n" +
                "\t<li>Moncler – Down Vest “Dupres”</li>\n" +
                "\t<li>Moncler – Sweater</li>\n" +
                "\t<li>Liu Jo – Clutch</li>\n" +
                "\t<li>Altea – Scarf</li>\n" +
                "\t<li>Lis Lab – Blazer</li>\n" +
                "\t<li>Guess – Scarf</li>\n" +
                "\t<li>Jucca - Sweater</li>\n" +
                "\t<li>Le Pandorine - Handbag</li>\n" +
                "\t<li>Le Pandorine - Handbag</li>\n" +
                "\t<li>Le Pandorine - Handbag</li>\n" +
                "\t<li>Save the Duck – Casual Jacket \"Sold\"</li>\n" +
                "\t<li>Luis Trenker – Casual Jacket \"Stuart\"</li>\n" +
                "\t<li>Liu Jo - Bag</li>\n" +
                "\t<li>#maximilianlook 102</li>\n" +
                "\t<li>Chamonix – Casual Jacket \"Fabrice\"</li>\n" +
                "\t<li>Save my Bag - Handbag \"Port\"</li>\n" +
                "\t<li>Michael Kors – Bag “Selma”</li>\n" +
                "\t<li>Michael Kors –Bag “Hamilton”</li>\n" +
                "\t<li>Michael Kors –Bag “Harper”</li>\n" +
                "\t<li>#maximilianlook 27</li>\n" +
                "\t<li>#maximilianlook 32</li>\n" +
                "\t<li>#maximilianlook 29</li>\n" +
                "\t<li>#maximilianlook 30</li>\n" +
                "\t<li>#maximilianlook 48</li>\n" +
                "\t<li>#maximilianlook 50</li>\n" +
                "\t<li>Michael Kors – Polo</li>\n" +
                "\t<li>Oakwood – Cape</li>\n" +
                "\t<li>Altea – Scarf</li>\n" +
                "\t<li>Belt – Guess “Lea“ </li>\n" +
                "\t<li>Profanter – Bucket Bag “Olivia”</li>\n" +
                "\t<li>Moncler – Down Jacket “Rodin”</li>\n" +
                "\t<li>Moncler – Down Jacket “Vallier”</li>\n" +
                "\t<li>Moncler – Down Jacket “Ryan”</li>\n" +
                "\t<li>Moncler – Down Jacket “Jacob”</li>\n" +
                "\t<li>Our exQuisite Corpse - Skull “Santos Brown”</li>\n" +
                "\t<li>Our exQuisite Corpse - Skull “Geometr Blu”</li>\n" +
                "\t<li>Guess – Shopper “Audrey”</li>\n" +
                "\t<li>360 Sweater – Sweater</li>\n" +
                "\t<li>Golden Goose – T-Shirt</li>\n" +
                "\t<li>Guess – Scarf</li>\n" +
                "\t<li>Le Pandorine - Bag </li>\n" +
                "\t<li>Happiness - Sweatpants \"Turca Strass\"</li>\n" +
                "\t<li>Maison Scotch - Hat</li>\n" +
                "\t<li>#maximilianlook 6</li>\n" +
                "\t<li>#maximilianlook 9</li>\n" +
                "\t<li>Profanter – Bag “Tina”</li>\n" +
                "\t<li>Profanter – Bag “Tina”</li>\n" +
                "\t<li>#maximilianlook 46</li>\n" +
                "\t<li>#maximilianlook 49</li>\n" +
                "\t<li>Etro – Scarf</li>\n" +
                "\t<li>Gabs – Bag “Sofia”</li>\n" +
                "</ul>");

        //question for audience
        //how to achieve sorted result
//        final String separator = "\n--------------------------------------------\n";
//        final String sorted = productList.stream()
//                .map(product -> product.getName().get(ENGLISH))
////                .sorted()
//                //arguments can all be the same
//                .collect(Collectors.joining(separator, separator, separator));
//        assertThat(sorted).isEqualTo("\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 102\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 11\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 11\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 12\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 14\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 15\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 15\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 16\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 16\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 17\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 18\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 19\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 20\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 21\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 21\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 22\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 24\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 25\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 27\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 28\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 28\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 29\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 3\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 3\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 30\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 31\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 32\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 32\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 34\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 4\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 45\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 46\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 48\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 49\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 5\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 5\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 50\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 6\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 6\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 62\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 7\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 70\n" +
//                "--------------------------------------------\n" +
//                "#maximilianlook 9\n" +
//                "--------------------------------------------\n" +
//                "360 Sweater – Sweater\n" +
//                "--------------------------------------------\n" +
//                "Altea – Scarf\n" +
//                "--------------------------------------------\n" +
//                "Altea – Scarf\n" +
//                "--------------------------------------------\n" +
//                "Belt – Guess “Lea“ \n" +
//                "--------------------------------------------\n" +
//                "Chamonix – Casual Jacket \"Fabrice\"\n" +
//                "--------------------------------------------\n" +
//                "Closed – Jeans „Worker X”\n" +
//                "--------------------------------------------\n" +
//                "Codello - Scarf “I MOG DI!”\n" +
//                "--------------------------------------------\n" +
//                "Etro – Scarf\n" +
//                "--------------------------------------------\n" +
//                "Gabs – Bag “Sofia”\n" +
//                "--------------------------------------------\n" +
//                "Golden Goose – T-Shirt\n" +
//                "--------------------------------------------\n" +
//                "Guess – Bag “Aliza”\n" +
//                "--------------------------------------------\n" +
//                "Guess – Hand bag “Privacy“\n" +
//                "--------------------------------------------\n" +
//                "Guess – Handbag\n" +
//                "--------------------------------------------\n" +
//                "Guess – Handbag “Greyson“\n" +
//                "--------------------------------------------\n" +
//                "Guess – Scarf\n" +
//                "--------------------------------------------\n" +
//                "Guess – Scarf\n" +
//                "--------------------------------------------\n" +
//                "Guess – Shopper “Audrey”\n" +
//                "--------------------------------------------\n" +
//                "Happiness - Sweat- Jacket\n" +
//                "--------------------------------------------\n" +
//                "Happiness - Sweatpants \"Turca Strass\"\n" +
//                "--------------------------------------------\n" +
//                "Happiness – T- Shirt\n" +
//                "--------------------------------------------\n" +
//                "Jucca - Sweater\n" +
//                "--------------------------------------------\n" +
//                "Jucca – Knit Sweater\n" +
//                "--------------------------------------------\n" +
//                "Le Pandorine - Bag \n" +
//                "--------------------------------------------\n" +
//                "Le Pandorine - Handbag\n" +
//                "--------------------------------------------\n" +
//                "Le Pandorine - Handbag\n" +
//                "--------------------------------------------\n" +
//                "Le Pandorine - Handbag\n" +
//                "--------------------------------------------\n" +
//                "Le Pandorine – Shopper “Shopper 71”\n" +
//                "--------------------------------------------\n" +
//                "Lis Lab – Blazer\n" +
//                "--------------------------------------------\n" +
//                "Liu Jo - Bag\n" +
//                "--------------------------------------------\n" +
//                "Liu Jo – Clutch\n" +
//                "--------------------------------------------\n" +
//                "Luis Trenker – Casual Jacket \"Stuart\"\n" +
//                "--------------------------------------------\n" +
//                "Maison Scotch - Hat\n" +
//                "--------------------------------------------\n" +
//                "Majestic Filatures – Turtleneck\n" +
//                "--------------------------------------------\n" +
//                "Michael Kors – Bag “Selma”\n" +
//                "--------------------------------------------\n" +
//                "Michael Kors – Polo\n" +
//                "--------------------------------------------\n" +
//                "Michael Kors –Bag “Hamilton”\n" +
//                "--------------------------------------------\n" +
//                "Michael Kors –Bag “Harper”\n" +
//                "--------------------------------------------\n" +
//                "Moncler – Down Jacket “Jacob”\n" +
//                "--------------------------------------------\n" +
//                "Moncler – Down Jacket “Rodin”\n" +
//                "--------------------------------------------\n" +
//                "Moncler – Down Jacket “Ryan”\n" +
//                "--------------------------------------------\n" +
//                "Moncler – Down Jacket “Vallier”\n" +
//                "--------------------------------------------\n" +
//                "Moncler – Down Vest “Dupres”\n" +
//                "--------------------------------------------\n" +
//                "Moncler – Sweater\n" +
//                "--------------------------------------------\n" +
//                "Oakwood – Cape\n" +
//                "--------------------------------------------\n" +
//                "Our exQuisite Corpse - Skull “Geometr Blu”\n" +
//                "--------------------------------------------\n" +
//                "Our exQuisite Corpse - Skull “Santos Brown”\n" +
//                "--------------------------------------------\n" +
//                "Our exQuisite Corpse - Skull “Santos Green”\n" +
//                "--------------------------------------------\n" +
//                "Profanter – Bag “Helen”\n" +
//                "--------------------------------------------\n" +
//                "Profanter – Bag “Helen”\n" +
//                "--------------------------------------------\n" +
//                "Profanter – Bag “Tina”\n" +
//                "--------------------------------------------\n" +
//                "Profanter – Bag “Tina”\n" +
//                "--------------------------------------------\n" +
//                "Profanter – Bucket Bag “Olivia”\n" +
//                "--------------------------------------------\n" +
//                "Profanter – Bucket Bag “Olivia”\n" +
//                "--------------------------------------------\n" +
//                "Save my Bag - Handbag \"Kaki\"\n" +
//                "--------------------------------------------\n" +
//                "Save my Bag - Handbag \"Port\"\n" +
//                "--------------------------------------------\n" +
//                "Save the Duck – Casual Jacket \"Sold\"\n" +
//                "--------------------------------------------\n" +
//                "Zanellato – Bag “Chianti”\n" +
//                "--------------------------------------------\n");
    }
}

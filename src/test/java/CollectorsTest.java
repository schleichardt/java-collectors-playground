import io.sphere.sdk.categories.Category;
import io.sphere.sdk.json.SphereJsonUtils;
import io.sphere.sdk.models.Reference;
import io.sphere.sdk.models.ResourceView;
import io.sphere.sdk.products.ProductProjection;
import io.sphere.sdk.products.ProductVariantAvailability;
import io.sphere.sdk.products.queries.ProductProjectionQuery;
import io.sphere.sdk.taxcategories.TaxCategory;
import org.junit.Test;

import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static java.util.Locale.ENGLISH;
import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CollectorsTest {
    private static List<ProductProjection> productList = SphereJsonUtils.readObjectFromResource("productsQueryResult.json", ProductProjectionQuery.resultTypeReference()).getResults();


    @Test
    public void toListCollector() {
        final List<String> skuList = productList.stream()
                .flatMap(product -> {
                    final Stream<String> variantsSkuStream = product.getAllVariants()
                            .stream()
                            .map(variant -> variant.getSku());
                    return variantsSkuStream;
                })
                .collect(toList());
        assertThat(skuList).containsExactly("s15look22", "s15look3", "A0E200000002CHD", "s15look41", "s15look11", "s15look13", "s15look66", "s15look6", "s15look29", "s15look33", "s15look42", "s15look44", "s15look9", "A0E200000002HFF", "A0E200000002HFP", "s15look95", "A0E20000000284I", "s15look28", "A0E200000002849", "s15look39", "s15look127", "s15look141", "M0E20000000FQZN", "M0E20000000FQZO", "M0E20000000FQZP", "M0E20000000FQZQ", "M0E20000000FQZR", "M0E20000000FQZS", "M0E20000000FQZT", "M0E20000000FQZU", "A0E200000002EFN", "A0E200000002ERD", "s15look48", "s15look59", "s15look62", "s15look5", "s15look4", "s15look23", "s15look21", "s15look30", "s15look34", "s15look56", "s15look55", "s15look65", "s15look31", "s15look36", "A0E20000000285K", "A0E200000002HM8", "A0E200000002CS7", "s15look54", "M0E20000000F8FT", "M0E20000000F8FU", "M0E20000000F8FV", "M0E20000000F8FW", "M0E20000000F8FX", "M0E20000000F8FY", "M0E20000000F8FZ", "M0E20000000F8G0", "M0E20000000EU1J", "M0E20000000EU1K", "M0E20000000EU1L", "M0E20000000EU1M", "M0E20000000EU1N", "M0E20000000EU1O", "M0E20000000EU1P", "M0E20000000EU1Q", "M0E20000000FQY3", "M0E20000000FQY4", "M0E20000000FQY5", "M0E20000000FQY6", "M0E20000000FQY7", "M0E20000000FQY8", "M0E20000000FQY9", "M0E20000000FQYA", "A0E200000002J3U", "M0E20000000FB8J", "M0E20000000FB8K", "M0E20000000FB8L", "M0E20000000FB8M", "M0E20000000FB8N", "M0E20000000FB8O", "M0E20000000FB8P", "M0E20000000FB8Q", "M0E20000000FB8R", "M0E20000000FB8S", "M0E20000000FB8T", "M0E20000000FB8U", "M0E20000000FB8V", "M0E20000000FB8W", "M0E20000000FB8X", "M0E20000000FB8Y", "M0E20000000FB8Z", "A0E200000002L31", "M0E20000000F1WB", "M0E20000000F1WC", "M0E20000000F1WD", "M0E20000000F1WE", "M0E20000000F1WF", "M0E20000000F1WG", "M0E20000000F1WH", "M0E20000000F1WI", "M0E20000000F1WL", "M0E20000000F1WM", "M0E20000000F1WN", "M0E20000000F1WO", "M0E20000000F1WP", "M0E20000000F1WQ", "M0E20000000F1WR", "M0E20000000F1WS", "A0E200000002FH6", "A0E2000000028GO", "M0E20000000F155", "M0E20000000F156", "M0E20000000F157", "M0E20000000F158", "M0E20000000F159", "M0E20000000F15A", "M0E20000000F15B", "M0E20000000F15C", "M0E20000000F15D", "M0E20000000F15E", "M0E20000000F15F", "M0E20000000F15G", "M0E20000000F15H", "A0E200000002IZA", "M0E20000000EU3R", "M0E20000000EU3S", "M0E20000000EU3T", "M0E20000000EU3U", "M0E20000000EU3V", "M0E20000000EU3W", "M0E20000000EU3X", "M0E20000000EU3Y", "A0E200000002E35", "A0E200000002EBR", "A0E200000002E23", "M0E20000000EWHB", "M0E20000000EWHC", "M0E20000000EWHD", "M0E20000000EWHE", "M0E20000000EWHF", "M0E20000000EWHG", "M0E20000000EWHH", "M0E20000000EWHI", "M0E20000000EPP7", "M0E20000000EPP8", "M0E20000000EPP9", "M0E20000000EPPA", "M0E20000000EPPB", "M0E20000000EPPC", "M0E20000000EPPD", "M0E20000000EPPE", "M0E20000000EPPF", "M0E20000000EPPG", "M0E20000000EPPH", "M0E20000000EPPI", "M0E20000000EPPJ", "A0E200000002G15", "s15look204", "M0E20000000F2EH", "M0E20000000F2EI", "M0E20000000F2EJ", "M0E20000000F2EK", "M0E20000000F2EL", "M0E20000000F2EM", "M0E20000000F2EN", "M0E20000000F2EO", "M0E20000000F2EP", "M0E20000000F2EQ", "M0E20000000F2ER", "M0E20000000F2ES", "M0E20000000F2ET", "A0E200000002L35", "A0E200000002H0P", "A0E200000002GYH", "A0E200000002H2X", "s15look47", "s15look52", "s15look63", "s15look64", "s15look98", "s15look100", "M0E20000000FJLP", "M0E20000000FJLQ", "M0E20000000FJLR", "M0E20000000FJLS", "M0E20000000FJLT", "M0E20000000FJLU", "M0E20000000FJLV", "M0E20000000FJLW", "A0E200000002AWS", "A0E2000000028BX", "M0E20000000EQLL", "M0E20000000EQLM", "M0E20000000EQLN", "M0E20000000EQLO", "M0E20000000EQLP", "M0E20000000EQLQ", "M0E20000000EQLR", "M0E20000000EQLS", "A0E200000002HM6", "M0E20000000F1T7", "M0E20000000F1T8", "M0E20000000F1T9", "M0E20000000F1TA", "M0E20000000F1TB", "M0E20000000F1TC", "M0E20000000F1TD", "M0E20000000F1TE", "M0E20000000F1TF", "M0E20000000F1TG", "M0E20000000F1TH", "M0E20000000F1TI", "M0E20000000F1TJ", "M0E20000000F1TK", "M0E20000000F1TL", "M0E20000000F1TM", "M0E20000000F1TV", "M0E20000000F1TW", "M0E20000000F1TX", "M0E20000000F1TY", "M0E20000000F1TZ", "M0E20000000F1U0", "M0E20000000F1U1", "M0E20000000F1U2", "M0E20000000F1TN", "M0E20000000F1TO", "M0E20000000F1TP", "M0E20000000F1TQ", "M0E20000000F1TR", "M0E20000000F1TS", "M0E20000000F1TT", "M0E20000000F1TU", "A0E200000002CHF", "A0E200000002CHG", "A0E20000000285J", "M0E20000000EV4F", "M0E20000000EV4G", "M0E20000000EV4H", "M0E20000000EV4I", "M0E20000000EV4J", "M0E20000000EV4K", "M0E20000000EV4L", "M0E20000000EV4M", "M0E20000000F9GZ", "M0E20000000F9H0", "M0E20000000F9H1", "M0E20000000F9H2", "M0E20000000F9H3", "M0E20000000F9H4", "M0E20000000F9H5", "M0E20000000F9H6", "A0E200000002866", "A0E200000002EFF", "M0E20000000FQUJ", "M0E20000000FQUK", "M0E20000000FQUL", "M0E20000000FQUM", "M0E20000000FQUN", "M0E20000000FQUO", "M0E20000000FQUP", "M0E20000000FQUQ", "A0E20000000293T", "s15look12", "s15look17", "A0E200000002HML", "A0E200000002HMM", "s15look96", "s15look99", "A0E2000000027IG", "A0E200000002B42", "A0E200000002B47", "A0E200000002B4H", "A0E200000002B4R", "A0E200000002B4S");
    }

    @Test
    public void toSetCollector() {
        final Set<Reference<TaxCategory>> taxCategories = productList.stream()
                .map(product -> product.getTaxCategory())
                .collect(toSet());
        final Reference<TaxCategory> taxCategory = TaxCategory.referenceOfId("990ee5bd-d439-47b4-ad0a-3e89e57f3790");
        final Set<Reference<TaxCategory>> expected = Collections.singleton(taxCategory);
        assertThat(taxCategories).isEqualTo(expected);

        //if you want a distinct list this is also possible:
        final List<Reference<TaxCategory>> taxCategoryList = productList.stream()
                .map(product -> product.getTaxCategory())
                .distinct()//filter out duplicates using equals method
                .collect(toList());
        assertThat(taxCategoryList).isEqualTo(singletonList(taxCategory));
    }

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

    @Test
    public void partitioningByCollector() {
        //in Scala there is a partition method on List which returns a tuple" (List[ProductProjection], List[ProductProjection])
        final Map<Boolean, List<ProductProjection>> availabilityMap = productList.stream()
                .collect(Collectors.partitioningBy(product -> {
                    final ProductVariantAvailability availability = product.getMasterVariant().getAvailability();
                    return availability == null ? false : availability.isOnStock();
                }));
        final List<ProductProjection> availableProducts = availabilityMap.getOrDefault(true, emptyList());
        final List<ProductProjection> notAvailableProducts = availabilityMap.getOrDefault(false, emptyList());
        assertThat(availableProducts).hasSize(60);
        assertThat(notAvailableProducts).hasSize(40);
    }

    @Test
    public void partitioningByCollectorWithDownStream() {
        final Predicate<ProductProjection> partitionPredicate = product -> {
            final ProductVariantAvailability availability = product.getMasterVariant().getAvailability();
            return availability == null ? false : availability.isOnStock();
        };

        final Map<Boolean, List<String>> availabilityProductIdListMap = productList.stream()
                .collect(Collectors.partitioningBy(partitionPredicate,
                        mapping(product -> product.getId(), toList())));

        final List<String> availableProducts = availabilityProductIdListMap.getOrDefault(true, emptyList());
        final List<String> notAvailableProducts = availabilityProductIdListMap.getOrDefault(false, emptyList());
        assertThat(availableProducts).hasSize(60).startsWith("9d6e8891-301d-42e0-81b5-308e79bd748c",
                "7ef45f58-38e8-4227-9c89-281e8876d523",
                "ff7b1ee0-d164-4758-8044-979c0f8bcd51");
        assertThat(notAvailableProducts).hasSize(40);
    }

    @Test
    public void groupingByCollector() {
        final Function<ProductProjection, String> productToCategory = product -> {
            //categories is a set, so we pick the one with the
            //lowest ID for a product
            return new ArrayList<>(product.getCategories())
                    .stream()
                    .map(cat -> cat.getId())
                    .sorted()
                    .findFirst()
                    .orElse(null);
        };
        final Map<String, List<ProductProjection>> categoryIdToProductListMap = productList.stream()
                .collect(groupingBy(productToCategory));

        final List<ProductProjection> productsOfCategory =
                categoryIdToProductListMap.get("dbe882ad-c026-4658-9b55-d14f593de200");
        assertThat(productsOfCategory).hasSize(2);
    }

    @Test
    public void groupingByCollectorWithDownstream() {
        final Function<ProductProjection, String> productToCategory = product -> {
            //categories is a set, so we pick the one with the
            //lowest ID for a product
            return new ArrayList<>(product.getCategories())
                    .stream()
                    .map(cat -> cat.getId())
                    .sorted()
                    .findFirst()
                    .orElse(null);
        };
        final Map<String, List<String>> categoryIdToProductIdListMap = productList.stream()
                .collect(groupingBy(productToCategory, mapping(ResourceView::getId, toList())));
        final List<String> productIdsOfCategory =
                categoryIdToProductIdListMap.get("dbe882ad-c026-4658-9b55-d14f593de200");
        assertThat(productIdsOfCategory).hasSize(2);
    }

    @Test
    public void reducingCollector() {
        //see https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html#reducing-java.util.function.BinaryOperator-
    }

    @Test
    public void toMapCollector() {
        //groupingByCollector gives you a Map<K,List<T>>
        //mapping is a collector which applies a function to every stream element and has a downstream collector
        //toMap gives you a Map<K, U>
        final Map<String, Long> productIdToVersionMap = productList.stream()
                .collect(toMap(ResourceView::getId, ResourceView::getVersion));
        final Long version = productIdToVersionMap.get("f1103a6e-b12c-4876-8593-a58f872c5bec");
        assertThat(version).isEqualTo(15);

        //in a loop it would be
        final Map<String, Long> map = new HashMap<>();
        for (final ProductProjection product : productList) {
            map.put(product.getId(), product.getVersion());
        }//4 lines vs. 2 lines

        assertThat(map).isEqualTo(productIdToVersionMap);
    }

    @Test
    public void collectingAndThenCollector() {
        //https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html#collectingAndThen-java.util.stream.Collector-java.util.function.Function-
        final List<String> ids = productList.stream()
                .map(ResourceView::getId)
                //maybe useful if you want an immutable list
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));

        //should be the same as

        final List<String> ids2 = Collections.unmodifiableList(productList.stream()
                .map(ResourceView::getId)
                .collect(toList()));
    }

    @Test
    public void summingIntCollector() {
        final Integer allVariantsCount = productList.stream()
                .collect(summingInt(product -> product.getAllVariants().size()));
        assertThat(allVariantsCount).isEqualTo(275);

        //also possible
        final int sum = productList.stream()
                .mapToInt(product -> product.getAllVariants().size())//IntStream
                .sum();
        assertThat(allVariantsCount).isEqualTo(sum);
    }

    @Test
    public void listBulkCollector() {


    }
}

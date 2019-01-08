
import java.util.Scanner;

public class stateflowerandbird {

    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);
        //array
        String[][] states = {
            {"Alabama", "Flower: Camelia", "Bird: Yellowhammer"},
            {"Alaska", "Flower: Forget-me-not", "Bird: Willow Ptarmigan "},
            {"Arizona", "Flower: Blossom of the Saguaro Cactus", "Bird: Cactus Wren "},
            {"Arkansas", "Flower: Apple blossom", "Bird: Mockingbird "},
            {"Califorina", "Flower: Golden Poppy", "Bird: California Valley Quail"},
            {"Colorado", "Flower: Rocky Mountian columbine", "Bird: Lark Bunting"},
            {"Connecticut", "Flower: Mountain Laurel ", "Bird: American Robin"},
            {"Delaware", "Flower: Peach blossom", "Bird: Blue Hen Chicken"},
            {"Florida", "Flower: Orange blossom ", "Bird: Mockingbird "},
            {"Georgia", "Flower: Cherokee Rose ", "Bird: Brown Thrasher ",},
            {"Hawaii", "Flower: Yello Hibiscus ", "Bird: Hawaiian Goose"},
            {"Idaho", "Flower: Syringa ", "Bird: Mountain Bluebird  "},
            {"Illinois", "Flower: Violet ", "Bird: Cardinal "},
            {"Indiana", "Flower: Peony ", "Bird: Cardinal "},
            {"Iowa ", "Flower: Wild Rose ", "Bird: Eastern Goldfinch "},
            {"Kansas", "Flower: Sunflower", "Bird: Western Meadowlark"},
            {"Kentucky", "Flower: Goldenrod ", "Bird: Cardinal"},
            {"Louisiana", "Flower: Magnolia ", "Bird: Eastern Brown Pelican "},
            {"Maine", "Flower: White Pinecone ", "Bird: Chickadee "},
            {"Maryland", "Flower: Black-eyed Susan ", "Bird: Baltimore Oriole"},
            {"Massachusetts", "Flower: Mayflower ", "Bird: Chickadee "},
            {"Michigan", "Flower: Apple blossom", "Bird: American Robin "},
            {"Minnesota", "Flower: Pink and white Lady's Slipper ", "Bird: Common Loon"},
            {"Mississippi", "Flower: Magnolia", "Bird: Mockingbird "},
            {"Missouri", "Flower: Hawthorn", "Bird: Bluebird "},
            {"Montana", "Flower: Bitterroot ", "Bird: Western Meadowlark "},
            {"Nebraska", "Flower: Goldenrod", "Bird: Western Meadowlark"},
            {"Nevada", "Flower: Sagebrush ", "Bird: Mountain Bluebird "},
            {"New Hampshire ", "Flower: Purple Lilac ", "Bird: Purple Finch "},
            {"New Jersey", "Flower: Violet ", "Bird: Eastern Goldfinch "},
            {"New Mexico", "Flower: Yucca flower", "Bird: Greater Roadrunner  "},
            {"New York", "Flower: Rose", "Bird: Eastern Bluebird "},
            {"North Carolina", "Flower: Dogwood", "Bird: Cardinal "},
            {"North Dakota", "Flower: Wild Prairie Rose ", "Bird: Western Meadowlark "},
            {"Ohio", "Flower: Scarlet Carnation ", " Cardinal: "},
            {"Oklahoma", "Flower: Mistletoe ", "Bird: Scissor-tailed Flycatcher "},
            {"Oregon", "Flower: Oregon Grape ", "Bird: Western Meadowlark "},
            {"Pennsylvania", "Flower: Mountain Laurel", "Bird: Ruffed Grouse"},
            {"Rhode Island", "Flower: Violet", "Bird: Rhode Island Red "},
            {"South Carolina", "Flower: Yellow Jessamine ", "Bird: Carolina Wren",},
            {"South Dakota ", "Flower: Pasqueflower ", "Bird: Ring-necked Pheasant"},
            {"Tennessee", "Flower: Iris", "Bird: Mockingbird ",},
            {"Texas", "Flower: Bluebonnet ", "Bird: Mockingbird "},
            {"Utah", "Flower: Sego Lily", "Bird: California Gull "},
            {"Vermont", "Flower: Red Clover ", "Bird: Hermit Thrush"},
            {"Virginia", "Flower: Flowering dogwood", "Bird: Cardinal"},
            {"Washington", "Flower: Rhododendron", "Bird: Willow goldfinch "},
            {"West Virginia", "Flower: Rhododendron", "Bird: Cardinal "},
            {"Wisconsin", "Flower: Wood Violet ", "Bird: American Robin "},
            {"Wyoming", "Flower: Indian Paintbrush ", "Bird: Western Meadowlark "}};
        // While Loop
        while (true) {

            // Prompt user input 
            System.out.println("Enter a state or None to exit: ");
            String stateName = input.nextLine();
            if (stateName.equalsIgnoreCase("None")) {
                System.out.println("****Thank You****\nA summary report for each State, Bird, and Flower is:\n");
                {
                    System.exit(0);
                }
            } else {
                // For loop to search through array
                for (int row = 0, column = 0; row < states.length; row++) {
                    // If statement for matching input string to array data
                    if (states[row][0].equalsIgnoreCase(stateName)) {
                        System.out.println("Bird: " + states[row][column + 1]);
                        System.out.println("Flower: " + states[row][column + 2] + "\n");

                    }

                }

            }

        }
    }
}

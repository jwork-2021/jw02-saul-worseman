package S191220072;
import java.util.*;
import S191220072.Line.Position;
public class MonsterArray {
    static ArrayList<Monster> monsters = new ArrayList<>();
    static{
        // ArrayList<Integer> Val = new ArrayList<>();
        // for(int i = 0; i < 64; i++){
        //     Val.add(3*i);
        // }
        // Collections.shuffle(Val);
        // for(int i = 0; i < 64; i++)
        // monsters.add(new Monster(Val.get(i), Val.get(i), Val.get(i)));
        boolean[] existed = new boolean[255  * 3 + 1];
        for(int i = 0; i < 756; i++){
            existed[i] = false;
        } 
        int randomR ;  // 0 to 255
        int randomG ;
        int randomB ;
        while(monsters.size() < 64){
            randomR = (int)(Math.random() * 256);  // 0 to 255
            randomG = (int)(Math.random() * 256);
            randomB = (int)(Math.random() * 256);
            if(!existed[randomB + randomG + randomR]){
                monsters.add(new Monster(randomR, randomG, randomB));
                existed[randomB + randomG + randomR] = true;
            }
        }
    }
    public static Monster getMonsterByColor(int color) {

        for (Monster monster: monsters) {
            if (monster.color() == color) {
                return monster;
            }
        }
        return null;

    }
    public static Iterator<Monster> iterator(){
        return monsters.iterator();
    }

    public static void main(String[] args){
        for(Monster monster : monsters){
            System.out.println(monster);
        }
    }
}

// class Monster implements Linable {

//     private final int r;
//     private final int g;
//     private final int b;

//     private Position position;

//     Monster(int r, int g, int b) {
//         this.r = r;
//         this.g = g;
//         this.b = b;
//     }

//     public int color() {
//         return this.r + this.g + this.b;
//     }

//     @Override
//     public String toString() {
//         return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m    " + this.color() + "  \033[0m";
//     }

//     @Override
//     public void setPosition(Position position) {
//         this.position = position;
//     }

//     @Override
//     public Position getPosition() {
//         return this.position;
//     }

//     public void swapPosition(Monster another) {
//         Position p = another.position;
//         this.position.setLinable(another);
//         p.setLinable(this);
//     }

//     @Override
//     public int getValue() {
//         return this.color();
        
//     }

// }
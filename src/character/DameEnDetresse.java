/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package character;

import java.util.Random;

/**
 *
 * @author zawae
 */
public enum DameEnDetresse {
        Jade,
        Ambre,
        Rose,
        Sophie,
        Olivia,
        Isabella,
        Harper,
        Camilia,
        Elizabeth,
        Eleanor,
        Ella,
        Ava,
        Emily,
        Nora,
        Hazel,
        Lily,
        Aurora,
        Riley,
        Lucy,
        Maya,
        Ruby,
        Ana;

        public static DameEnDetresse getRandomDameEnDetresse() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
    }

/**
 * Singularity Mod for Minecraft.
 * Copyright (C) 2015 Infinity Studio.
 * <p/>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * @license GPLv3
 */
package org.infinitystudio.singularity.api.research;

import net.minecraft.util.StatCollector;
import org.infinitystudio.singularity.SingularityLogger;

import java.util.Random;


/**
 * @author Darkhighness
 */
public class Researches {
    public static String[] researchTexts;
    public static int researchAmount = 100;

    public static void getAlltext()
    {
        for(int i = 0;i<researchAmount;i++) {
            if(StatCollector.canTranslate("text.research." + i))
            researchTexts[i] = (StatCollector.translateToLocal("text.research." + i));
            else {
                SingularityLogger.Log("Total" + i + "Researches Have Benn Got!");
                researchTexts = new String[i];
                return;
            }
        }
    }

    public static void Fuzzy()
    {
        short FuzzyLevel = 10;
        Random r = new Random();
        for(String str : researchTexts)
        {
            byte done = 0;
            byte i = 0;
            if(!(str.length() / FuzzyLevel >= 10)) {
                 FuzzyLevel = (short)(str.length() / 15);
            }

            char[] s = str.toCharArray();
            while(i < FuzzyLevel) {
                s[r.nextInt(str.length() - 1)] = ' ';
                i ++;
            }

            researchTexts[done] = s.toString();
            done ++;
        }
    }
}

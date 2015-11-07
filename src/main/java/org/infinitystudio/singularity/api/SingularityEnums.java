/**
 * Singularity Mod for Minecraft. Copyright (C) 2015 Infinity Studio.
 * <p/>
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * <p/>
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * <p/>
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 *
 * @license GPLv3
 */
package org.infinitystudio.singularity.api;

public class SingularityEnums {
    public enum NodeType {
        NORMAL, // 正常
        WEAK, // 虚弱
        OVERLOAD, // 超载
        REVERSE, // 逆向
        FEEDBACK, // 反噬
        RECOVERY, // 恢复
    }

    public enum CeremonyType {

    }

    public enum OriginCoreType {
        COMMON, // 普遍
        RARE, // 稀有
        EPIC, // 史诗
        LEGEND, // 传说
        UNKNOWN, // 未知
        CREATIVE,// 创造
    }

    public enum ResourceInteractType {
        Input,
        Output
    }
}

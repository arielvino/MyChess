package com.arielvinograd.mychess;

/**
 * This enum represent different types of possible targets.
 * Usually, a target is an attribute given to cells that indicate that the cell is a target location for certain move.
 * The "None" meant that the cell is currently not a target.
 */
public enum Target {
    None,
    Move,
    Capture,
    Castling,
    Promotion
}

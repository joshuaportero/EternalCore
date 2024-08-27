package com.eternalcode.core.feature.privatechat;

import com.eternalcode.core.user.User;

record PrivateMessage(User sender, User target, String message) { }
